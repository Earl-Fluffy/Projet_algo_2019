public class Depenses {
	double montant;
	String type;
	String description;
	
	public Depenses (double amount, String categorie, String note){
		montant = amount;
		type = categorie;
		description=note;
	}
	
	public String toString(){
		return "Nouvelle dépense d'un montant de " + montant + " de type " + type + " : " + description;
	}
}

