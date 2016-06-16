package SE2.CRM_System;

import javafx.scene.web.HTMLEditor;

public class Driver {
	
	public void add(String type, String Name, String Vorname, String Straße, int Hausnummer,
			int Postleitzahl, String Stadt, String Land, String Telefon,
			int Kundennummer, HTMLEditor Notiz){
		
		
		Notiz.setPrefHeight(245);
         
		Notiz.setStyle(
                 "-fx-font: 12 cambria;"
                 + "-fx-border-color: black; "
                 + "-fx-border-width: 10;"
             );
         
         final String INITIAL_TEXT = "<html><body>Kontaktfenster, falls noch kein Kontakt zu diesem Kunden angelegt, bitte hier anlegen:</body></html>";

         Notiz.setHtmlText(INITIAL_TEXT);
         
		
		FactoryKunde.add(type, Name, Vorname, Straße, Hausnummer, Postleitzahl, Stadt, Land, Telefon, Kundennummer,Notiz);
		
		
	}
	
	
	public void add (){
		
		HTMLEditor Notiz = new HTMLEditor();
		Notiz.setPrefHeight(245);
        
		Notiz.setStyle(
                 "-fx-font: 12 cambria;"
                 + "-fx-border-color: black; "
                 + "-fx-border-width: 10;"
             );
         
         final String INITIAL_TEXT = "<html><body>Kontaktfenster, falls noch kein Kontakt zu diesem Kunden angelegt, bitte hier anlegen:</body></html>";

         Notiz.setHtmlText(INITIAL_TEXT);
		
		FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße",
				1, 72121, "Musterstadt", "Musterland", "0711/12334567", 001,Notiz);
		
		FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 002,Notiz);
	}
}
