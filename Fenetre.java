import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Fenetre extends JFrame implements ActionListener{
    PLoading pLoad=new PLoading(); // A voir si nécessaire...
    PCity pCity;
    PEntree pEntree= new PEntree();
    PStat pStat;
    CardLayout c1= new CardLayout();
    String[] listContent = {"CITY","ENTREE","LOADING","SAVING","STATS"};
    JPanel cards = new JPanel(c1);
    
    
    public Fenetre(String[][] batACreer){
        this.setSize(800,700); //Propriétés de la fenetre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        pCity= new PCity(batACreer); //Création et ajout des paneaux
        
        cards.add(pCity,listContent[0]);
        cards.add(pEntree,listContent[1]);
        cards.add(pLoad,listContent[2]);
        
        this.setContentPane(cards);
        
        pEntree.annuler.addActionListener(this); //ActionListener de tous les boutons qui doivent être écoutés par l'extérieur
        pEntree.ok.addActionListener(this);
        pCity.bNouvelleEntree.addActionListener(this);
        pCity.bStats.addActionListener(this);
        
        //Test (à retirer)
        Depenses testDepense = new Depenses(40, "Test","Je fais un test",2019,05,12);
        Depenses testDepense2 = new Depenses(10,"Test2","Ttttt",2019,05,13);
        Depenses testDepense3 = new Depenses(1,"Test3","taydgdgf",2019,05,15);
        ArrayList<Depenses> listTest = new ArrayList<Depenses>();
        listTest.add(testDepense);
        listTest.add(testDepense2);
        listTest.add(testDepense3);
        //pStat=new PStat(listTest);
        //cards.add(pStat,listContent[4]);

        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
		if (e.getSource()==pEntree.annuler){
			c1.show(cards,listContent[0]);
		} else if (e.getSource()==pCity.bNouvelleEntree){
			c1.show(cards,listContent[1]);
		} else if (e.getSource()==pCity.bStats){
			pStat=new PStat(pCity.myMap.sommer());
			cards.add(pStat,listContent[4]);
			c1.show(cards,listContent[4]);
		} else if (e.getSource()== pEntree.ok){
		    if(!pEntree.jourTextField.getText().equals("Date dd") && !pEntree.moisTextField.getText().equals("Mois MM") && !pEntree.anneeTextField.getText().equals("Année yyyy") && pEntree.montant.getValue() != null) {
                int jour = Integer.parseInt(pEntree.jourTextField.getText());
                int mois = Integer.parseInt(pEntree.moisTextField.getText());
                int annee = Integer.parseInt(pEntree.anneeTextField.getText());
                String note = pEntree.notes.getText();
                int numCategorie = pEntree.categorie.getSelectedIndex()+1;
                double montant = Double.parseDouble(pEntree.montant.getText().replace(",", "."));
                Batiment nouveauBat = pCity.myMap.quelTypeBatiment(new String[]{"0", "0", "0", "" + numCategorie}); //Batiment créé mais sa position n'est pas encore bonne
                while(nouveauBat.niveau<2) {
                    for (Batiment bat : pCity.myMap.listBat) {
                        if (bat.getClass().equals(nouveauBat.getClass()) && bat.niveau == nouveauBat.niveau) {
                            nouveauBat.fusion(bat, pCity.myMap);
                            pCity.cityBack.remove(bat.myPanel);
                            break;
                        }
                    }
                }

                nouveauBat.trouverPosition(pCity.myMap);
                pCity.myMap.ajoutBat(nouveauBat);
                Depenses nouvelleDepense = new Depenses(montant, nouveauBat.toString(), note, annee, jour, mois);
                nouveauBat.liste.add(nouvelleDepense);
                pCity.dessiner();
                c1.show(cards, listContent[0]);
            } else {
		        JOptionPane.showMessageDialog(null,"Formulaire incomplet !","Alerte",JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    

}
