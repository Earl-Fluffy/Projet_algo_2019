public class Interpolationv2{
	private double[]x;
	private Matrix y;
	private Matrix matVandermonde;
	private double [] coeffs;
	
	public Interpolationv2(double [] xx, double[] yy){
		
		x=xx;
		y=new Matrix(yy.length,1);
		System.out.println(y);
		for (int i=0; i<yy.length;i++){
			y.set(i,0,yy[i]);
			System.out.println(y.get(i,0));
		}
		matVandermonde=new Matrix(x.length ,yy.length);
		//coeff=new Matrix(x.length ,1);
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x.length;j++){
				matVandermonde.set(i,j,Math.pow(x[i],j));
			}
		}
		Matrix coeff=matVandermonde.solve(y);
		coeffs=new double[yy.length];
		for(int i=0;i<yy.length;i++){
			coeffs[i]=coeff.get(i,0);
		}
	}

	public double[] getCoeff(){
		return this.coeffs;
	}
}

