import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Semaphore;

public class Parking extends JPanel {
    ImageIcon img;

    static boolean[] isEmpty; // true if empty , false if not
    static Semaphore entryControl;

    static int capacity=3;
    static int occupiedSpaces;

    public Parking(){
        entryControl=new Semaphore(1,true);
        isEmpty=new boolean[4];
        for(int i=0;i<4; i++){
            isEmpty[i]=true;
        }


    }

    int places(){
        return Parking.capacity-Parking.occupiedSpaces;
    }

    synchronized boolean accept(Car myVoit) {

        if (this.places() >0 )
        {

            this.occupiedSpaces ++ ;
            System.out.format("[Parking] :%s acceptée, il reste %d places \n", myVoit.name,
                    this.places());
            System.out.format("Voiture Garees\n");

            return (true) ;

        }
        else {
            System.out.format("Parking : %s refusée, il reste %d places \n",
                    myVoit.name,this.places());
            return(false) ;
        }
    }
    synchronized void leave(Car myVoit) {
        occupiedSpaces --;
        System.out.format("Parking :[%s] est sortie, reste %d places\n", myVoit.name, places());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        img =new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\gate77.png");
        img.paintIcon(this, g, WIDTH,WIDTH);

    }

}
