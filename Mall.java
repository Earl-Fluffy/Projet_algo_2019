public class Mall extends Batiment{
	
	public Mall (int x, int y){
		super (x,y);
	}
	public void attribuerIm(){
		switch (niveau){
			case 0:
			image = images.mall1;
			break;
			case 1:
			image = images.mall2;
			break;
			case 2:
			image =images.mall3;
			break;
		}
	}
	
	public String toString(){
		return "5";
	}
}

