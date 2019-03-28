import java.util.*;

public class Depenses {
	double montant;
	String type;
	String description;
	int date;
	
	public Depenses (double amount, String categorie, String note){
		montant = amount;
		type = categorie;
		description=note;
		date= this.convertDate();
	}
	
	public int convertDate(){
		int num =0;
		Calendar cal = new GregorianCalendar(); 
		int year = cal.get(Calendar.YEAR);             // 2005
		int month = cal.get(Calendar.MONTH);           // 0=Jan, 1=Feb, ...
		int day = cal.get(Calendar.DAY_OF_MONTH);      // 1...
		int time = cal.get(Calendar.HOUR_OF_DAY);
		num +=(2019-year) + month + day +time;
		return num;
	}
	
	
	public String toString(){
		return "Nouvelle dépense d'un montant de " + montant + " de type " + type + " : " + description;
	}
}

