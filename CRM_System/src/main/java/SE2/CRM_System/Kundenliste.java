package SE2.CRM_System;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kundenliste {

	public static ObservableList<Kunde> listeDerKunden = FXCollections.observableArrayList();
	
	public Kundenliste() {
//		this.listeDerKunden.add(new Kunde("Kunde", "Lustig", "Peter", 0, 0, null, null, null, 0));
		//this.listeDerKunden.add(new Kunde("Kunde", "Gans", "Gustav", "Nelkenweg", 3, 70707, "Entenhausen", "Entenland", "0715468945", 003));
	
		
	
	}
	
	public void show() {
		
		for (int i = 0; i < listeDerKunden.size(); i++) {
			System.out.println(listeDerKunden.get(i));

		}

	}

	public IKunde search(String SuchtermName) {

		for (int i = 0; i < listeDerKunden.size(); i++) {
			if (listeDerKunden.get(i).equals(SuchtermName)) {
				return listeDerKunden.get(i);
			}

		}
		System.out.println("Nicht gefunden");
		return null;
	}

}
