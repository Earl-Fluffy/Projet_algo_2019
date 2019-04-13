import java.io.*;
import java.util.ArrayList;

public class Main{


    public static void main(String[] args) {
        System.out.println("hi");
        String fileContent = " ";



        try {
			String adressedufichier = "media/tDoc.txt";
			
			FileReader fr = new FileReader(TestMain.class.getResource(adressedufichier).getPath());
			BufferedReader br = new BufferedReader(fr);
			
			String texte = "";
			String thisLine;
			int a = 0;
				while((thisLine=br.readLine()) !=null)
				{
					texte = texte + thisLine + "\n";
					a++;		
				}
			br.close();

			fileContent+=texte;
			fileContent=fileContent.trim();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String value[]=fileContent.split("\n");
		
		String finalValue[][]=new String [value.length][4];		
		for (int i=0;i<finalValue.length;i++){
					finalValue[i]=value[i].split (";");
				}

		Fenetre laFenetre = new Fenetre(finalValue);
			
		}
}
    
  
