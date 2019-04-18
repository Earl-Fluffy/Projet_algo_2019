import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PLoading extends JPanel {
    PLoading(){

    }

    public void paintComponent (Graphics g){
        Image img = null;
        try {
            img= ImageIO.read(new File(Main.class.getResource("media/Load.png").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img,0,0,this.getHeight(),this.getWidth(),this);
    }
}
