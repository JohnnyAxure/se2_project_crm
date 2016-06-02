package SE2.CRM_System;

import javafx.beans.property.SimpleStringProperty;

public class FactoryKunde extends Kundenliste{

	public static IKunde add(String type, String Name, String Vorname,
			String Straße, int Hausnummer, int Postleitzahl, String Stadt,
			String Land, String Telefon, int Kundennummer) {

		if (type.equals("Kunde")) {
			
			Kunde temp = new Kunde(type, Name, Vorname, Straße, Hausnummer, Postleitzahl, Stadt, Land, Telefon, Kundennummer);
			
			listeDerKunden.add(temp);
//			return new Kunde(Name, Vorname, Straße, Hausnummer, Postleitzahl,
//					Stadt, Land, Telefon, Kundennummer);
return temp;			
			
		} else {
			return null;
		}

	}
}
