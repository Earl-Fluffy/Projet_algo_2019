import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PEntree extends JPanel {

    comboB categorie;
    final String[] categories={"Revenu","Alimentation","Transport","Loisir","Maison","Electronique","Médical","Vêtements","Autre"};
    //Alimentation, boisson, transport, loisir, maison, électronique, médical, autre, revenu, vêtements

    public PEntree() {
        this.setLayout(null);
        categorie = new comboB(categories);
        categorie.setBounds(100,100,400,50);

        this.add(categorie);
    }

    public class comboB extends JComboBox{
        private Image img= null;
        comboB(String[] arg){
            super(arg);
            try{
                img= ImageIO.read(new File(Main.class.getResource("media/cate.bmp").getPath()));
            } catch (IOException e){
                e.printStackTrace();
            }

        }

        public void paintComponent (Graphics g) {

            g.drawImage (img,0,0,this.getWidth(),this.getHeight(),this);
            g.drawString(this.getSelectedItem().toString(),10,10);
            //getSelectedItem
        }
    }
}
