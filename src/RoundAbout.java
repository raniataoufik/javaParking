import javax.swing.*;
import java.awt.*;

public class RoundAbout extends JLabel {
    ImageIcon bar;
    int x;
    int y;

    public RoundAbout(){
        this.x=850;
        this.y=297;

        bar=new ImageIcon("C:\\Users\\hp\\IdeaProjects\\javaPro\\images\\R.png");
        this.setIcon(bar);
        Dimension dim=this.getPreferredSize();
        setBounds(x,y,dim.width,dim.height);

    }
}
