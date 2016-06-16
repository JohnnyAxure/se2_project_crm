package SE2.CRM_System;

import javafx.scene.web.HTMLEditor;
//
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
	
	
	public void add_wirklichjetzt (){
		
		HTMLEditor Notiz = new HTMLEditor();
		Notiz.setPrefHeight(245);
        
		Notiz.setStyle(
                 "-fx-font: 12 cambria;"
                 + "-fx-border-color: black; "
                 + "-fx-border-width: 10;"
             );
         
         final String INITIAL_TEXT = "<html><body>Kontaktfenster, falls noch kein Kontakt zu diesem Kunden angelegt, bitte hier anlegen:</body></html>";

         Notiz.setHtmlText(INITIAL_TEXT);
         
         HTMLEditor NotizC = new HTMLEditor();
 		NotizC.setPrefHeight(245);
         
 		NotizC.setStyle(
                  "-fx-font: 12 cambria;"
                  + "-fx-border-color: black; "
                  + "-fx-border-width: 10;"
              );
          
          final String INITIAL_TEXTC = "<html><body>Kontaktfenster, falls noch kein Kontakt zu diesem Kunden angelegt, bitte hier anlegen:<p>Neuer Kunde seit 03.06.16, möchte eine große Menge Aktien unsreres Unternemhens erwerben. Treffen mit der Geschäftsführung morgen um 11:00</p></body></html>";

          NotizC.setHtmlText(INITIAL_TEXTC);
         
		
		IKunde a = FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße", 1, 72121, "Musterstadt", "Musterland", "0711/12334567", 1,Notiz);
		
		IKunde b = FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 2,Notiz);
		
		IKunde c = FactoryKunde.add("Kunde", "Doe", "John", "Doestraße", 27, 70179, "Doestadt", "Doeland", "07156/987321", 3, NotizC);
		
		IKunde d = FactoryKunde.add("Kunde", "Mustermann", "Max", "Musterstraße", 12, 70654, "Musterstadt", "Mustertstadt", "0711/234765", 4, Notiz);
		
		IKunde e = FactoryKunde.add("Kunde", "Rodriguez", "Rico", "Promenadenweg", 4, 60578, "Barcelona", "Spanien", "758327123", 5, Notiz);
		
		IKunde f = FactoryKunde.add("Kunde", "Belic", "Niko", "Boulevardstreet", 1205, 89123, "Liberty City", "United States of America", "632134596", 6, Notiz);
		
		IKunde g = FactoryKunde.add("Kunde", "De Santa", "Michael", "Richroad", 37, 75345, "Los Santos", "USA", "10239485", 7, Notiz);
		
		IKunde h = FactoryKunde.add("Kunde", "Potz", "Paul", "Berlinerstraße", 54, 79912, "Berlin", "Deutschland", "65456465", 8, Notiz);
		
		IKunde i = FactoryKunde.add("Kunde", "D.Roosevelt", "Franklin", "Promistreet", 87, 53255, "London", "England", "6087968888", 9, Notiz);
		
		IKunde j = FactoryKunde.add("Kunde", "Pescatore", "Pino", "Pastastraße", 21, 87566, "Rom", "Italien", "86868686", 10, Notiz);
		
		IKunde k = FactoryKunde.add("Kunde", "Gost", "Günther", "Belgerstraße", 35, 36547, "Schnaroff", "Belgien", "869635", 11, Notiz);
		
		IKunde l = FactoryKunde.add("Kunde", "Isako", "Iskirm", "Kötbullarstraße", 57, 34765, "Elkebelk", "Schweden", "44444", 12, Notiz);
		
		IKunde m = FactoryKunde.add("Kunde", "Metschhuka", "Machuala", "Ugandastraße", 64, 67332, "Machuali", "Ghana", "66666", 13, Notiz);
		
		IKunde n = FactoryKunde.add("Kunde", "Gonzales", "Gabriella", "Fuegostraße", 23, 56749, "BongoBongo", "Argentinien", "5382345", 14, Notiz);
		
		IKunde o = FactoryKunde.add("Kunde", "Anders", "Agnis", "Coldstraße", 52, 16856, "Quebec", "Kanada", "53395", 15, Notiz);
		
		IKunde p = FactoryKunde.add("Kunde", "Gonneraeu", "Josephine", "Parisienne Straße", 86, 89758, "Paris", "Frankreich", "3584298", 16, Notiz);
		
		IKunde q = FactoryKunde.add("Kunde", "Ibrahimonov", "Ibrahim", "Stolenstraße", 45, 94445, "Warschau", "Polen", "99678673", 17, Notiz);
		
		IKunde r = FactoryKunde.add("Kunde", "Dustov", "Dimitri", "Chostovstraße", 21, 94463, "Rastowitz", "Rumänien", "54534534", 18, Notiz);
		
		IKunde s = FactoryKunde.add("Kunde", "Isnitzov", "Pavlov", "Tschatankastraße", 35, 65432, "Moskau", "Russland", "54587899", 19, Notiz);
		
		IKunde t = FactoryKunde.add("Kunde", "Vu", "Anh Tuan", "Tschinglao Straße", 65, 65676, "Tchilau", "Vietnam", "23122878", 20, Notiz);
		
		IKunde u = FactoryKunde.add("Kunde", "Rostova", "Masha", "Muskovstraße", 13, 83453, "Madrid", "Ukraine", "65343453", 21, Notiz);
		
		IKunde v = FactoryKunde.add("Kunde", "Bergales", "Giusella", "Abrancastraße", 07, 43794, "Barcelona", "Spanien", "87323467", 22, Notiz);
		
		IKunde w = FactoryKunde.add("Kunde", "Müller", "Maximilian", "Gartenstraße", 03, 75354, "Frankfurt", "Deutschland", "78081280", 23, Notiz);
		
		IKunde x = FactoryKunde.add("Kunde", "Xu", "Gungmi", "Misahustraße", 45, 75354, "Seoul", "Korea", "63452368", 24, Notiz);
		
		IKunde y = FactoryKunde.add("Kunde", "Fu", "Mushu", "Mutschangstraße", 642, 056743, "Tokio", "Japan", "356399442", 25, Notiz);
		
		IKunde z = FactoryKunde.add("Kunde", "Roon", "Tom", "Breadstraße", 46, 325696, "Hauserstadt", "England", "085323423", 26, Notiz);
		
		
		
	}
}
