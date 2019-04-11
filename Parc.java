public class Parc extends Batiment{
	
	public Parc (int x, int y){
		super (x,y);
		coef = 0.1;		
	}
	
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"parc n1";	
			break;
			case 2:
			image = "\"media\"parc n2";
			break;
			case 3:
			image ="\"media\"parc n3";
			break;
		}
	}
	
	public String toString(){
		return "4";
	}
	
}

