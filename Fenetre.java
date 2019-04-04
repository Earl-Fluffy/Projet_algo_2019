import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Fenetre extends JFrame implements ActionListener{
    PLoading pLoad=new PLoading();
    PCity pCity= new PCity();
    PEntree pEntree= new PEntree();
    Courbe pCourbe;
    CardLayout c1= new CardLayout();
    String[] listContent = {"CITY","ENTREE","LOADING","SAVING","STATS"};
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
        pCity.bNouvelleEntree.addActionListener(this);
        
        
        /*Depenses testDepense = new Depenses(5.5, "Test","Je fais un test",2019,05,12);
        ArrayList<Depenses> listTest = new ArrayList<Depenses>();
        listTest.add(testDepense);
        pCourbe=new Courbe(listTest);
        cards.add(pCourbe,listContent[4]);
        c1.show(cards,listContent[4]);*/
        
        
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
		if (e.getSource()==pEntree.annuler){
			c1.show(cards,listContent[0]);
		} else if (e.getSource()==pCity.bNouvelleEntree){
			c1.show(cards,listContent[1]);
		}

    }
    
    

}
