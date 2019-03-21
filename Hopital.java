public class Hopital extends Batiment{
	
public Hopital (int x, int y){
		super (x,y);
		coef = 0.1;	
		switch (niveau){
			case 1:
			image = "\"media\"Hopital n1";	
			coef = 0.2;
			break;
			case 2:
			image = "\"media\"hopital n2";
			break;
			case 3:
			image ="\"media\"hopital n3";
			break;
		}
			
		
	}
	
	public String toString(){
		return " : Hopital ";
	}
	
	
}

