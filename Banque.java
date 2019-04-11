public class Banque extends Batiment{
	
	public Banque (int x, int y){
		super (x,y);
		coef = 0.1;	
	}	
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"bank n1";	
			break;
			case 2:
			image = "\"media\"bank n2";
			break;
			case 3:
			image ="\"media\"bankn3";
			break;
		}
	}
	
	public String toString(){
		return "6";
	}
	
}


