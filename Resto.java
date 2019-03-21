public class Resto extends Batiment {
	
	public Resto (int x, int y){
		super (x,y);
		coef = 0.1;
	}
		
	
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"resto n1";	
			break;
			case 2:
			image = "\"media\"resto n2";
			break;
			case 3:
			image ="\"media\"resto n3";
			break;
		}
	}
	
	public String toString(){
		return " : Restaurant ";
	}
	
	
}

