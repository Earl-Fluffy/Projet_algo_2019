public class Cinema extends Batiment{
	
	public Cinema (int x, int y){
		super (x,y);
	}
	
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.cinema1;
			break;
			case 1:
			image = images.cinema2;
			break;
			case 2:
			image =images.cinema3;
			break;
		}
	}
	
	public String toString(){
		return "8";
	}
	
}

