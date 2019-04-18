import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
    	long tempsActuel= System.currentTimeMillis();
        String texte=""; //Variable qui récupère les infos de tDoc
		long tempsDepuisDernièreOuverture=0;
		String texteDepenses="";

        try { //Lecture de tDoc et date
			FileReader fr = new FileReader(Main.class.getResource("media/tDoc.txt").getPath());
			BufferedReader br = new BufferedReader(fr);

			String thisLine;
			while((thisLine=br.readLine()) !=null && thisLine!="") {
				texte = texte + thisLine + "\n";
			}
			texte=texte.trim(); //Enlève les espaces inutiles
			br.close();
			fr.close();
			fr= new FileReader(Main.class.getResource("media/date.txt").getPath());
			br = new BufferedReader(fr);
			long date=br.read();
			br.close();
			fr.close();
			tempsDepuisDernièreOuverture=tempsActuel-date;
			fr=new FileReader(Main.class.getResource("media/depenses.txt").getPath());
			br = new BufferedReader(fr);
			while((thisLine=br.readLine()) !=null && thisLine!="") {
				texteDepenses = texteDepenses + thisLine + "\n";
			}

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String value[] = texte.split("\n"); //Découpe de texte à chaque à la ligne
		String valueDepenses[] = texteDepenses.split("\n");
		String finalValue[][] = new String[value.length][4];
		String finalValueDepenses[][] = new String[valueDepenses.length][2];
		for (int i = 0; i < finalValue.length; i++) {
			finalValue[i] = value[i].split(";"); //Découpe de value à chaque ;
		}
		for(int i=0;i<finalValueDepenses.length;i++){
			finalValueDepenses[i]=valueDepenses[i].split(";");
		}
		Fenetre laFenetre = new Fenetre(finalValue); // Lancement de la fenêtre principale
		laFenetre.pCity.myMap.gagneArgentLaunch(tempsDepuisDernièreOuverture);
		if(!finalValueDepenses[0][0].equals("")) {
			laFenetre.pCity.myMap.depensesArchives=laFenetre.pCity.myMap.creerDepensesArchives(finalValueDepenses);
			laFenetre.pCity.myMap.depensesArchivesString = texteDepenses;
		}
		}
}
    
  
