import java.io.*;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
        String texte=""; //Variable qui récupère les infos de tDoc

        try { //Lecture de tDoc et date
			FileReader fr = new FileReader(TestMain.class.getResource("media/tDoc.txt").getPath());
			BufferedReader br = new BufferedReader(fr);
			long date=br.read();
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

		}
}
    
  
