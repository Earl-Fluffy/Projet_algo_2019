import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
    	long tempsActuel= System.currentTimeMillis();
        String texte=""; //Variable qui récupère les infos de tDoc
		long tempsDepuisDernièreOuverture=0;

        try { //Lecture de tDoc et date
			FileReader fr = new FileReader(Main.class.getResource("media/tDoc.txt").getPath());
			FileReader fr2 = new FileReader(Main.class.getResource("media/date.txt").getPath());
			BufferedReader br = new BufferedReader(fr);
			BufferedReader br2 = new BufferedReader(fr2);
			long date=br2.read();
			tempsDepuisDernièreOuverture=tempsActuel-date;
			String thisLine;
			int a = 0;
				while((thisLine=br.readLine()) !=null && thisLine!="")
				{
					texte = texte + thisLine + "\n";
					a++;		
				}
			br.close();

			texte=texte.trim(); //Enlève les espaces inutiles
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String value[] = texte.split("\n"); //Découpe de texte à chaque à la ligne

		String finalValue[][] = new String[value.length][4];
		for (int i = 0; i < finalValue.length; i++) {
			finalValue[i] = value[i].split(";"); //Découpe de value à chaque ;
		}
		Fenetre laFenetre = new Fenetre(finalValue); // Lancement de la fenêtre principale
		laFenetre.pCity.myMap.gagneArgentLaunch(tempsDepuisDernièreOuverture);
		}
}
    
  
