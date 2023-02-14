import javax.swing.*;
import java.awt.*;

public class Car extends JLabel implements Runnable {
    ImageIcon car;
    String name;
    public int x;
    public int y;
    static int xMax;
    Parking p=new Parking();


    public Car(String name,int x,int y){
        this.name=name;
        this.x=x;
        this.y=y;
        car=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\car_dim.png");
        this.setIcon(car);
        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);
    }


    //icon change to simulate the car entering the parking position
    public void setIcon(){
        car=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\car2_dim.png");
        this.setIcon(car);
        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);

    }

    //go into parking
    synchronized public void goIn(){

            this.x = this.x + 15;
            this.setLocation(this.x, this.y);

    }

    //park car
    synchronized public void park(){
        this.y=this.y-15;
        this.setLocation(this.x,this.y);
    }

    //reset car position
    synchronized public void resetPos(){
        this.y=this.y+15;
        this.setLocation(this.x,this.y);
    }


    //reset car icon
    public void resetIcon(){
        car=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\car_dim.png");
        this.setIcon(car);
        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);
    }

    //reset car icon for leaving
    public void IconOut(){
        car=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\car3_dim.png");
        this.setIcon(car);
        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);
    }



    @Override
    public void run() {
        System.out.format("[%s]: Je débute ! \n", this.name);
        try {

            Parking.entryControl.acquire();
            Thread.sleep(2500);
            Parking.entryControl.release();
            System.out.format("[%s]: Je demande à rentrer \n", this.name);

            //go into the parking lot into position 1
            if(Parking.isEmpty[0] ) {
                while (this.x <= 470) {
                    this.goIn();
                    Thread.sleep(100);
                }

                xMax=470;
                Parking.isEmpty[0]=false;
            }

            //go into the parking into position 2
            else {
                while(this.x<=xMax+150){
                    this.x = this.x + 12;
                    this.setLocation(this.x, this.y);
                    if(this.x==178){
                        System.out.println("test in");
                        Thread.sleep(1000);

                    }
                    Thread.sleep(100);
                    Parking.isEmpty[0]=false;

                }

                xMax+=150;


            }


            System.out.format("[%s]: entering Parking position \n", this.name);

            this.setIcon();
                   Thread.sleep(1000);

             //entering parking position
            while(this.y>=50){
                       park();
                       Thread.sleep(100);

                   }

                 p.accept(this);
                 Thread.sleep(4000);
                 System.out.format("[%s]: Je demande à sortir \n", this.name);

            //leave parking position
            while(this.y<=235){
                    resetPos();
                    Thread.sleep(100);
                }


                 this.resetIcon();
                p.leave(this);


                while(x<=1000){
                    this.x=this.x+11;
                    this.setLocation(this.x,this.y);
                    Thread.sleep(100);
                }
                this.setIcon();

            while(y<=320){
                this.y=this.y+11;
                this.setLocation(this.x,this.y);
                Thread.sleep(100);
            }
            this.IconOut();

            //leave parking lot
            while(this.x>=-100){
                this.x=this.x-11;
                this.setLocation(this.x,this.y);
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
