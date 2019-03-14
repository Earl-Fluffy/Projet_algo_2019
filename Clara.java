import java.util.Date;
public class Clara {
	double[][] matV;
	
	public void interpolation (double []dep, double []date, int n){
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				matV[i][j]=Math.pow(date[i],j);
			}
		}
	}
	// COMMENT INVERSER MATRICE ??
}
