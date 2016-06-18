package mainFunctionality;

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
		
		FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße", 1, 72121, "Musterstadt", "Musterland", "12334567", 1,Notiz);
		
		FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 2,Notiz);
		
		FactoryKunde.add("Kunde", "Doe", "John", "Broadway", 235, 78563, "New York", "Amerika", "8637688844", 3,Notiz);
		
		FactoryKunde.add("Kunde", "Kochmeier", "Benedikt", "Königsstraße", 29, 13245, "Stuttgart", "Deutschland", "8735444687", 4,Notiz);
		
		FactoryKunde.add("Kunde", "Gonzales", "Maria", "Sante Domenico", 38, 87690, "Barcelona", "Spanien", "1873548687", 5,Notiz);
		
		FactoryKunde.add("Kunde", "Lemmington", "Edward", "Quecumberstreet", 4, 45091, "London", "England", "2187687355", 6,Notiz);
		
		FactoryKunde.add("Kunde", "Gorbatschow", "Vladimir", "Leninstraße", 27, 56712, "Moskau", "Russland", "9387553486", 7,Notiz);
		
		FactoryKunde.add("Kunde", "Meier", "Hans", "Kleinstraße", 78, 24376, "Frankfurt", "Deutschland", "6346876454", 8,Notiz);
		
		FactoryKunde.add("Kunde", "Melark", "Peter", "Highstreet", 678, 13298, "Miami", "Amerika", "3648667567", 9,Notiz);
		
		FactoryKunde.add("Kunde", "Brown", "Louis", "Lowerstreet", 45, 67263, "Kapstadt", "Südafrika", "7345543456", 10,Notiz);
		
		FactoryKunde.add("Kunde", "Goldgräber", "Hannah", "Geldweg", 26, 70154, "Zürich", "Schweiz", "3354787516", 11,Notiz);
		
		FactoryKunde.add("Kunde", "Veniziante", "Laura", "Via Moda", 78, 07456, "Mailand", "Italien", "4568431686", 12,Notiz);
		
		FactoryKunde.add("Kunde", "Regeb", "Rodrik", "Budapesterstraße", 98, 56734, "Budapest", "Ungarn", "3687354486", 13,Notiz);
		
		FactoryKunde.add("Kunde", "Palzen", "Paula", "Olskeberg", 23, 98234, "Helsinki", "Finnland", "3643487312", 14,Notiz);
		
		FactoryKunde.add("Kunde", "Esmeraldo", "Angelika", "Sant Domenico", 997, 98456, "Madrid", "Spanien", "4254642432", 15,Notiz);
		
		FactoryKunde.add("Kunde", "Guhaeli", "Mohinder", "Upperstreet", 89, 57234, "Johannesburg", "Südafrika", "7654443335", 16,Notiz);
		
		FactoryKunde.add("Kunde", "Nitschev", "Raoul", "Chawortzstraße", 43, 70707, "Bukarest", "Rumänien", "8732432547", 17,Notiz);
		
		FactoryKunde.add("Kunde", "Hamamoto", "Yuri ", "Nagasakistreet", 12, 78456, "Osaka", "Japan", "9453424377", 18,Notiz);
		
		FactoryKunde.add("Kunde", "Yamashi", "Ando", "Tendostraße", 5, 78956, "Tokio", "Japan", "1423685435", 19,Notiz);
		
		FactoryKunde.add("Kunde", "Park", "Bong Soo", "Gangnamstraße", 7, 23765, "Seoul", "Süd Korea", "6853542243", 20,Notiz);
		
		FactoryKunde.add("Kunde", "Vu", "Xiumi", "Chiungstraße", 9, 85413, "Shanghai", "China", "9532143745", 21,Notiz);
		
		FactoryKunde.add("Kunde", "Ha", "Cheng", "Li Hao Straße", 11, 96734, "Peking", "China", "9535426864", 22,Notiz);
		
		FactoryKunde.add("Kunde", "Burger", "Paulette", "Broadway", 18, 65487, "Toronto", "Kanada", "0535424357", 23,Notiz);
		
		FactoryKunde.add("Kunde", "Speranza", "Gustavo", "Los Vamonos", 789, 23485, "Mexico City", "Mexiko", "3652867945", 24,Notiz);
		
		FactoryKunde.add("Kunde", "Esmeralda", "Elsa", "Salvadorstraße", 4, 94856, "San Salvador", "El Salvador", "1343869794", 25,Notiz);
		
		FactoryKunde.add("Kunde", "Petersen", "Kahtrin", "Wellingtonstreet", 45, 72365, "Wellington", "Neuseeland", "6784354625", 26,Notiz);
		
		FactoryKunde.add("Kunde", "Principe", "Alisha", "Via Valenzia", 14, 14372, "Ceglie", "Italien", "234567290", 27, Notiz);
		
	}
}
