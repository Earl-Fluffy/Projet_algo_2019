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
    Image cinema1;
    Image cinema2;
    Image cinema3;
    Image gare1;
    Image gare2;
    Image gare3;
    Image maison1;
    Image maison2;
    Image maison3;
    Image mall1;
    Image mall2;
    Image mall3;
    Image parc1;
    Image parc2;
    Image parc3;
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
            cinema1 = ImageIO.read(new File(Main.class.getResource("media/cinema1.jpg").getPath()));
            cinema2 = ImageIO.read(new File(Main.class.getResource("media/cinema2.jpg").getPath()));
            cinema3= ImageIO.read(new File(Main.class.getResource("media/cinema3.png").getPath()));
            gare1 = ImageIO.read(new File(Main.class.getResource("media/Gare1.jpg").getPath()));
            gare2 = ImageIO.read(new File(Main.class.getResource("media/gare2.jpg").getPath()));
            gare3 = ImageIO.read(new File(Main.class.getResource("media/gare3.png").getPath()));
            maison1 = ImageIO.read(new File(Main.class.getResource("media/maison1.jpg").getPath()));
            maison2 = ImageIO.read(new File(Main.class.getResource("media/maison2.jpg").getPath()));
            maison3 = ImageIO.read(new File(Main.class.getResource("media/maison3.gif").getPath()));
            mall1 = ImageIO.read(new File(Main.class.getResource("media/mall1.jpg").getPath()));
            mall2 = ImageIO.read(new File(Main.class.getResource("media/mall2.jpg").getPath()));
            mall3 = ImageIO.read(new File(Main.class.getResource("media/boutique3.gif").getPath()));
            parc1 = ImageIO.read(new File(Main.class.getResource("media/parc1.jpg").getPath()));
            parc2 = ImageIO.read(new File(Main.class.getResource("media/parc2.jpg").getPath()));
            parc3 = ImageIO.read(new File(Main.class.getResource("media/parc3.gif").getPath()));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
