package SE2.CRM_System;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.web.HTMLEditor;

public class FactoryKunde extends Kundenliste{

	public static IKunde add(String type, String Name, String Vorname,
			String Straße, int Hausnummer, int Postleitzahl, String Stadt,
			String Land, String Telefon, int Kundennummer,HTMLEditor Notiz) {

		if (type.equals("Kunde")) {
			
			Kunde temp = new Kunde(type, Name, Vorname, Straße, Hausnummer, Postleitzahl, Stadt, Land, Telefon, Kundennummer,Notiz);
			
			listeDerKunden.add(temp);
			
            return temp;			
			
		} else {
			
			return null;
		}

	}
}
