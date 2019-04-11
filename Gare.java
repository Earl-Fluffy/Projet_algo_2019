public class Gare extends Batiment{
	
	public Gare (int x, int y){
		super (x,y);
		coef = 0.1;		
	}
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"gare n1";	
			break;
			case 2:
			image = "\"media\"gare n2";
			break;
			case 3:
			image ="\"media\"gare n3";
			break;
		}
	}
	
	public String toString(){
		return "7";
	}
	
}

