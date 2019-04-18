import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class PanelImage extends JPanel { //Dédfinit un JPanel avec une image de fond
    private Image img=null;
    PanelImage(String pathname){
        try{
            img = ImageIO.read(new File(Main.class.getResource(pathname).getPath()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    PanelImage(Image img){
        this.img=img;
    }
    public void paintComponent(Graphics g){
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
    }
}