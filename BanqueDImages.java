import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BanqueDImages {
    Image banque1;
    Image banque2;
    Image banque3;
    Image hopital1;
    Image hopital2;
    Image hopital3;
    Image resto1;
    Image resto2;
    Image resto3;
    public BanqueDImages(){
        try{
            banque1 = ImageIO.read(new File(Main.class.getResource("media/bankn1.jpg").getPath()));
            banque2 = ImageIO.read(new File(Main.class.getResource("media/bankn2.jpg").getPath()));
            banque3 = ImageIO.read(new File(Main.class.getResource("media/bankn3.png").getPath()));
            hopital1 = ImageIO.read(new File(Main.class.getResource("media/hopitaln1.png").getPath()));
            hopital2 = ImageIO.read(new File(Main.class.getResource("media/hopitaln2.gif").getPath()));
            hopital3 = ImageIO.read(new File(Main.class.getResource("media/hopitaln3.gif").getPath()));
            resto1 = ImageIO.read(new File(Main.class.getResource("media/reston1.png").getPath()));
            resto2 = ImageIO.read(new File(Main.class.getResource("media/reston2.png").getPath()));
            resto3 = ImageIO.read(new File(Main.class.getResource("media/reston3.jpg").getPath()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
