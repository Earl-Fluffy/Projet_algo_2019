public class Mall extends Batiment{
	
	public Mall (int x, int y){
		super (x,y);
		coef = 0.1;		
	}
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"mall n1";	
			break;
			case 2:
			image = "\"media\"mall n2";
			break;
			case 3:
			image ="\"media\"mall n3";
			break;
		}
	}
	
	public String toString(){
		return " : Mall ";
	}
}

