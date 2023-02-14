import javax.swing.*;
import java.awt.*;

public class Bar extends JLabel {
    ImageIcon bar;
    int x;
    int y;

    public Bar(){
        this.x=280;
        this.y=219;

        bar=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\bar.png");
        this.setIcon(bar);

        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);
    }

}
