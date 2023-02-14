import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame=new JFrame();
        Parking p=new Parking();
        frame.setContentPane(p);
        p.setLayout(null);
        frame.setSize(1200,550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //creating car instances
        Car car=new Car("car1",180,250);
        Car car2=new Car("car2",70 , 250);

        //adding the cars to the Parking
        p.add(car);
        p.add(car2);

        //adding the gate to the parking
        Bar bar=new Bar();
        p.add(bar);


        //adding the roundabout to the parking
        RoundAbout rA=new RoundAbout();
        p.add(rA);
        p.add(rA);


        //creating threads
        Thread T1=new Thread(car);
        Thread T2=new Thread(car2);

        //starting threads to execute the run() method
        T1.start();
        T2.start();

    }
}