import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;


public class PEntree extends JPanel{

    comboB categorie;
    final String[] categories={"Médical","Alimentation","Maison","Autre","Vêtements","Revenu","Transport","Loisir",};
    //Alimentation, boisson, transport, loisir, maison, électronique, médical, autre, revenu, vêtements
	ghostFormattedTextField jourTextField;
	ghostFormattedTextField moisTextField;
	ghostFormattedTextField anneeTextField;
	JTextArea notes;
	JFormattedTextField montant;
	Bouton ok;
	Bouton annuler;
	Image img ;


    public PEntree(){

        try {
            img = ImageIO.read(new File(TestMain.class.getResource("media/entree.bmp").getPath())); //bloc try/catch gère les exceptions
        } catch (IOException e){
            e.printStackTrace();
        }

        this.setLayout(null);

        categorie = new comboB(categories); //Objet pour définir le type de dépense
        categorie.setBounds(350,170,350,50);
        
        jourTextField = new ghostFormattedTextField(new SimpleDateFormat("dd"),"Date dd"); //3 champs formatés pour la date
		jourTextField.setBounds(220,275,80,50);
		jourTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		moisTextField = new ghostFormattedTextField(new SimpleDateFormat("MM"),"Mois MM");
		moisTextField.setBounds(320,275,80,50);
		moisTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);
		anneeTextField = new ghostFormattedTextField(new SimpleDateFormat("yyyy"),"Année yyyy");
		anneeTextField.setBounds(420,275,160,50);
		anneeTextField.setFocusLostBehavior(JFormattedTextField.PERSIST);

		notes = new JTextArea(); //Permet à l'utilisateur d'anoter la dépense
		notes.setBounds(100,345,600,200);
		notes.setLineWrap(true);

		montant= new JFormattedTextField(new DecimalFormat());
		montant.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		montant.setBounds(100,170,80,50);

		ok = new Bouton("OK !","media/white.bmp"); //Bouton qui permet d'enregistrer l'entrée et de revenir à PCity
		ok.setBounds(180,600,160,50);
		annuler = new Bouton ("Annuler...","media/white.bmp"); //Bouton qui permet d'annuler et de retourner à PCity
		annuler.setBounds(460,600,160,50);

        this.add(categorie);
        this.add(jourTextField);
        this.add(moisTextField);
        this.add(anneeTextField);
        this.add(notes);
        this.add(montant);
        this.add(ok);
        this.add(annuler);
    }


    public void paintComponent (Graphics g){
        g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);

    }

    public class comboB extends JComboBox<String>{ //JComboBox avec une image fr fond
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
            g.setFont(new Font("TimesRoman",Font.PLAIN,25));
            g.drawString(this.getSelectedItem().toString(),this.getWidth()/4,(this.getHeight()/2)+7);
        }
    }
    
    public class ghostFormattedTextField extends JFormattedTextField implements FocusListener{ //JtextField avec un ghost texte
		private final String ghostText;
		private Color ghostColor;
		

		
		public ghostFormattedTextField(SimpleDateFormat format, String ghostText){
			super(format);
			this.ghostText=ghostText;
			ghostColor= new Color(192,192,192);
            this.setForeground(ghostColor);
            this.setText(ghostText);
            this.addFocusListener(this);
		}
		
		@Override
        public void focusGained(FocusEvent e) {
		    if(this.getText().equals(ghostText)){
                    this.setText("");
                    this.setForeground(Color.black);
		    }
        }

        @Override
        public void focusLost(FocusEvent e) {
		    if(this.getText().equals("")){
		        this.setForeground(ghostColor);
		        this.setText(ghostText);
            }
        }
        
	}

    public class ghostTextArea extends JTextArea implements FocusListener{ //JTextArea avec un ghostText
        private final String ghostText;


        public ghostTextArea(String ghostText){
            this.ghostText=ghostText;
            this.setForeground(new Color(192,192,192));
            this.setText(ghostText);
            this.setLineWrap(true);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if(ghostText.equals(this.getText())){
                this.setText("");
                this.setForeground(Color.black);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if(this.getText().equals("")){
                this.setForeground(new Color(192,192,192));
                this.setText(ghostText);
            }
        }

    }
}
