package SE2.CRM_System;

public class Driver {

	public static void main(String[] args) {

		
		
		
//		System.out.println(Kundenliste.listeDerKunden);
//		((Kundenliste) Kundenliste.listeDerKunden).show();
	

	
	}
	public void add_wirklichjetzt (){
		IKunde a = FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße",
				1, 72121, "Musterstadt", "Musterland", "0711/12334567", 001);
		
		IKunde b = FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 002);
	}
}
