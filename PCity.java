import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import java.io.*;




public class PCity extends JPanel implements ActionListener{
	private BorderLayout g1 = new BorderLayout();
	public Bouton bNouvelleEntree=new Bouton("","media/NouvelleEntree.gif");
	public Bouton bStats= new Bouton("","media/Stats.gif");
	public JButton close = new JButton ("Fermer");
	public Map myMap= new Map();
	
	PCity(){
		this.setLayout(g1);
		JPanel commande = new JPanel();
		commande.setLayout(null);
		commande.setBackground(Color.blue);
		commande.setPreferredSize(new Dimension(800,100));
		bNouvelleEntree.setBounds(100,15,200,67);
		bStats.setBounds(500,15,200,67);
		commande.add(bNouvelleEntree);
		commande.add(bStats);
		this.add(commande, BorderLayout.SOUTH);
		
		PanelImage cityBack = new PanelImage("media/CityBackground.jpg");
		this.add(cityBack,BorderLayout.CENTER);

		JPanel infoArgent = new JPanel();
		infoArgent.setLayout(null);
		infoArgent.setBackground(Color.blue);
		infoArgent.setPreferredSize(new Dimension(800,30));
		this.add(infoArgent,BorderLayout.NORTH);
		close.setBounds (700,0,100,30);
		close.setBackground(Color.red);
		infoArgent.add(close);
		close.addActionListener(this);
		
	}
	
	public void actionPerformed (ActionEvent e){
		myMap.save();
	System.exit(0);
	}
	
	 public static void usingBufferedWritter(String fileContent) throws IOException
    {


        BufferedWriter writer = new BufferedWriter(new FileWriter(TestMain.class.getResource("media/tDoc.txt").getPath()));
        // !!!!!! Ne pas toucher sinon mort potentielle du PC
        writer.write(fileContent);
        writer.close();
    }

    public static void appendFile(String fileContent) throws IOException
    {
        String thisLine;
        String res="";
        BufferedReader tBuff = new BufferedReader(new FileReader(TestMain.class.getResource("media/tDoc.txt").getPath()));
        while ((thisLine = tBuff.readLine()) != null) {
            res +="\n"+ thisLine;
        }
        tBuff.close();
        usingBufferedWritter(res + "\n" + fileContent);
    }
	
	
	
	public class PanelImage extends JPanel{
		private Image img=null;
		PanelImage(String pathname){
			try{
				img = ImageIO.read(new File(TestMain.class.getResource(pathname).getPath()));
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		public void paintComponent(Graphics g){
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		}
	}
}
