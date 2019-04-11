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
			int a = 0;
				while(a<2) //petite boucle 2 fois
				{
					texte = texte + br.readLine() + "\n";
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
		int k=0;
		int j=0;
		for (int i=0;i<finalValue.length;i++){
			//while (k<value.length){
				for (String val:value[k].split(";")) {
					finalValue[i][j]=val;
					// finalValue[i]=value[k].split (";");
					j++;
				}
			k++;
				j=0;
			//}
		}

		Fenetre laFenetre = new Fenetre(finalValue);
			
			//System.out.println(value[i]);
		}
}
    
  
