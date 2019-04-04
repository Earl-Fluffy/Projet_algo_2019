import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements ActionListener{
    PLoading pLoad=new PLoading();
    PCity pCity= new PCity();
    PEntree pEntree= new PEntree();
    CardLayout c1= new CardLayout();
    String[] listContent = {"CITY","ENTREE","LOADING","SAVING"};
    JPanel cards = new JPanel(c1);
    
    public Fenetre(){
        this.setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setContentPane(pEntree);
        this.setResizable(false);
        
        cards.add(pCity,listContent[0]);
        cards.add(pEntree,listContent[1]);
        cards.add(pLoad,listContent[2]);
        this.setContentPane(cards);
        
        pEntree.annuler.addActionListener(this);
        c1.show(cards,listContent[1]);
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
		if (e.getSource()==pEntree.annuler){
			c1.show(cards,listContent[0]);
		}

    }
    
    

}
