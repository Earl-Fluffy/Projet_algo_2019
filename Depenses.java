import java.util.*;

public class Depenses {
	double montant;
	String type;
	String description;
	double date;
	
	public Depenses (double amount, String categorie, String note){
		montant = amount;
		type = categorie;
		description=note;
		date= this.convertDate();
	}
	
	public double convertDate(){
		double num =0;
		Calendar cal = new GregorianCalendar(); 
		double year = cal.get(Calendar.YEAR);             // 2005
		double month = cal.get(Calendar.MONTH);           // 0=Jan, 1=Feb, ...
		double day = cal.get(Calendar.DAY_OF_MONTH);      // 1...
		double time = cal.get(Calendar.HOUR_OF_DAY);
		num +=(2019-year) + month + day +time;
		return num;
	}
	
	public double getAmount(){
		return this.montant;
	}
	
	public double getDate(){
		return this.date;
	}
	
	public String toString(){
		return "Nouvelle dépense d'un montant de " + montant + " de type " + type + " : " + description;
	}
}

