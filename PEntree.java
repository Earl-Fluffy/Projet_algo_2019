import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;


public class PEntree extends JPanel {

    comboB categorie;
    final String[] categories={"Revenu","Alimentation","Transport","Loisir","Maison","Electronique","Médical","Vêtements","Autre"};
    //Alimentation, boisson, transport, loisir, maison, électronique, médical, autre, revenu, vêtements
	JFormattedTextField jourTextField;
	JFormattedTextField moisTextField;
	JFormattedTextField anneeTextField;

    public PEntree() {
        this.setLayout(null);
        categorie = new comboB(categories);
        categorie.setBounds(100,100,350,50);
        
        jourTextField = new JFormattedTextField(new SimpleDateFormat("dd"));
		jourTextField.setBounds(100,300,80,50);
		jourTextField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		moisTextField = new JFormattedTextField(new SimpleDateFormat("MM"));
		moisTextField.setBounds(200,300,80,50);
		jourTextField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		anneeTextField = new JFormattedTextField(new SimpleDateFormat("yyyy"));
		anneeTextField.setBounds(300,300,160,50);
		jourTextField.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);

        this.add(categorie);
        this.add(jourTextField);
        this.add(moisTextField);
        this.add(anneeTextField);
    }

    public class comboB extends JComboBox<String>{
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
    
    public class ghostTextField implements FocusListener{
		private Color ghostColor;
		private boolean isEmpty;
		private final String ghostText;
		private JTextField textField = null;
		private JFormattedTextField formattedTextField = null;
		private boolean isFormatted;
		
		public ghostTextField (final JTextField textfield, String ghostText){
			this.textField=textField;
			this.ghostText=ghostText;
			isFormatted=false;
		}
		
		public ghostTextField(final JFormattedTextField formattedTextField, String ghostText){
			this.formattedTextField=formattedTextField;
			this.ghostText=ghostText;
			isFormatted=true;
		}
		
		@Override
        public void focusGained(FocusEvent e) {}
        @Override
        public void focusLost(FocusEvent e) {}
        
	}
}
