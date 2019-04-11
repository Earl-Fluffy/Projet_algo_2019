import java.io.*;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        System.out.println("hi");
        String fileContent = " ";
		ArrayList<Batiment> listBat;

        try {
			String adressedufichier = "media/tDoc.txt";
			
			FileReader fr = new FileReader(adressedufichier);
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
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        String value[]=fileContent.split("\n");
		
		String finalValue[][]=new String [value.length][4];
		int k=0;
		for (int i=0;i<=finalValue.length;i++){
			while (k<value.length){
			finalValue[i]=value[k].split (";");
			k++;
			}
		}
			
			//System.out.println(value[i]);
		}
}
    
  
