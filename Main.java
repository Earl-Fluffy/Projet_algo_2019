import java.io.*;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
        System.out.println("hi");
        String texte="";




        try {
			FileReader fr = new FileReader(TestMain.class.getResource("media/tDoc.txt").getPath());
			BufferedReader br = new BufferedReader(fr);
			

			String thisLine;
			int a = 0;
				while((thisLine=br.readLine()) !=null && thisLine!="")
				{
					texte = texte + thisLine + "\n";
					a++;		
				}
			br.close();

			texte=texte.trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



        String value[] = texte.split("\n");

		String finalValue[][] = new String[value.length][4];
		for (int i = 0; i < finalValue.length; i++) {
			finalValue[i] = value[i].split(";");
		}
		Fenetre laFenetre = new Fenetre(finalValue);

		}
}
    
  
