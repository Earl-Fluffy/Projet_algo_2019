public class Cinema extends Batiment{
	
	public Cinema (int x, int y){
		super (x,y);
	}
	
	public void attribuerIm(){
		switch (niveau){
			case 1:
			image = "\"media\"cinema n1";	
			break;
			case 2:
			image = "\"media\"cinema n2";
			break;
			case 3:
			image ="\"media\"cinema n3";
			break;
		}
	}
	
	public String toString(){
		return "8";
	}
	
}

