package SE2.CRM_System;

public class Driver {

	public static void main(String[] args) {

		
		
		
//		System.out.println(Kundenliste.listeDerKunden);
//		((Kundenliste) Kundenliste.listeDerKunden).show();
	

	
	}
	
	public void add(String type, String Name, String Vorname, String Straße, int Hausnummer,
			int Postleitzahl, String Stadt, String Land, String Telefon,
			int Kundennummer){
		
		FactoryKunde.add(type, Name, Vorname, Straße, Hausnummer, Postleitzahl, Stadt, Land, Telefon, Kundennummer);
		
		
	}
	
	
	public void add_wirklichjetzt (){
		IKunde a = FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße",
				1, 72121, "Musterstadt", "Musterland", "0711/12334567", 001);
		
		IKunde b = FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 002);
	}
}
