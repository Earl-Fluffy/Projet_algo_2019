import java.util.*;

public class Depenses implements Comparable <Depenses>{
	double montant;
	String type;
	String description;
	double date;
	int [] dateNonModif=new int[3];
	
	public Depenses (double amount, String categorie, String note, int annee, int jour, int mois){
		montant = amount;
		type = categorie;
		description=note;
		dateNonModif[0]=annee;
		dateNonModif[1]=mois;
		dateNonModif[2]=jour;
		date= this.convertDate(jour, mois, annee);
	}
	
	public double convertDate(int j, int m, int a){
		double num =0;
		//Calendar cal = new GregorianCalendar(); 
		//double year = cal.get(Calendar.YEAR)*365;             // 2005
		//double month = cal.get(Calendar.MONTH);           // 0=Jan, 1=Feb, ...
		//double day = cal.get(Calendar.DAY_OF_MONTH);      // 1...
		num +=(2019-a)*365 + m*30.4 + j;
		return num;
	}
	
	public double getAmount(){
		return this.montant;
	}
	
	public double getDate(){
		return this.date;
	}
	
	public int compareTo(Depenses autreDepense){
		int s=0;
		if (date < autreDepense.date)
			s=-1;
		else if (date > autreDepense.date)
			s =1;
		return s;
	}
	
	public String toString(){
		return "Nouvelle dépense d'un montant de " + montant + " de type " + type + " : " + description;
	}
}
