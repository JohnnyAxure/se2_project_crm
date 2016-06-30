package mainFunctionality;


/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/
import persons.FactoryKunde;

/**
 * Class which adds customer to the customer list
 */
public class Driver {
	
	/**
	 * adds new customer to the customer list
	 * @param type The type of our person. In this case: customer
	 * @param name surname of this customer
	 * @param vorname first name of the customer
	 * @param straße street in which the customer lives
	 * @param hausnummer house number 
	 * @param postleitzahl zip code of the city, where the customer lives
	 * @param stadt city, in which the customer lives
	 * @param land country, in which the customer lives
	 * @param telefon telephone number from the customer
	 * @param kundennummer the customer number
	 * @param notiz notes regarding the customer
	 */
	public void add(String type, String name, String vorname, String straße, int hausnummer,
			int postleitzahl, String stadt, String land, String telefon,
			int kundennummer, String notiz){
		

		FactoryKunde.add(type, name, vorname, straße, hausnummer, postleitzahl, stadt, land, telefon, kundennummer,notiz);
		
		
	}
	
	
	/**
	 * adds already declared customers to the customer list
	 */
	public void add (){
	
	
		FactoryKunde.add("Kunde", "Hans", "Peter", "Musterstraße", 1, 72121, "Musterstadt", "Musterland", "12334567", 1,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Gans", "Gustav", "Nelkenweg", 2, 70707, "Entenhausen", "Entenland", "0715468945", 2,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Doe", "John", "Broadway", 235, 78563, "New York", "Amerika", "8637688844",3, "13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Kochmeier", "Benedikt", "Königsstraße", 29, 13245, "Stuttgart", "Deutschland", "8735444687", 4,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Gonzales", "Maria", "Sante Domenico", 38, 87690, "Barcelona", "Spanien", "1873548687", 5,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Lemmington", "Edward", "Quecumberstreet", 4, 45091, "London", "England", "2187687355", 6,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Gorbatschow", "Vladimir", "Leninstraße", 27, 56712, "Moskau", "Russland", "9387553486", 7,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Meier", "Hans", "Kleinstraße", 78, 24376, "Frankfurt", "Deutschland", "6346876454", 8,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Melark", "Peter", "Highstreet", 678, 13298, "Miami", "Amerika", "3648667567", 9,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Brown", "Louis", "Lowerstreet", 45, 67263, "Kapstadt", "Südafrika", "7345543456", 10,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Goldgräber", "Hannah", "Geldweg", 26, 70154, "Zürich", "Schweiz", "3354787516", 11,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Veniziante", "Laura", "Via Moda", 78, 07456, "Mailand", "Italien", "4568431686", 12,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Regeb", "Rodrik", "Budapesterstraße", 98, 56734, "Budapest", "Ungarn", "3687354486", 13,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Palzen", "Paula", "Olskeberg", 23, 98234, "Helsinki", "Finnland", "3643487312", 14,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Esmeraldo", "Angelika", "Sant Domenico", 997, 98456, "Madrid", "Spanien", "4254642432", 15,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Guhaeli", "Mohinder", "Upperstreet", 89, 57234, "Johannesburg", "Südafrika", "7654443335", 16,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Nitschev", "Raoul", "Chawortzstraße", 43, 70707, "Bukarest", "Rumänien", "8732432547", 17,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Hamamoto", "Yuri ", "Nagasakistreet", 12, 78456, "Osaka", "Japan", "9453424377", 18,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Yamashi", "Ando", "Tendostraße", 5, 78956, "Tokio", "Japan", "1423685435", 19,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Park", "Bong Soo", "Gangnamstraße", 7, 23765, "Seoul", "Süd Korea", "6853542243", 20,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Vu", "Xiumi", "Chiungstraße", 9, 85413, "Shanghai", "China", "9532143745", 21,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Ha", "Cheng", "Li Hao Straße", 11, 96734, "Peking", "China", "9535426864", 22,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Burger", "Paulette", "Broadway", 18, 65487, "Toronto", "Kanada", "0535424357", 23,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Speranza", "Gustavo", "Los Vamonos", 789, 23485, "Mexico City", "Mexiko", "3652867945", 24,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Esmeralda", "Elsa", "Salvadorstraße", 4, 94856, "San Salvador", "El Salvador", "1343869794", 25,"14.03.15 Kunde war nicht erreichbar");
		
		FactoryKunde.add("Kunde", "Petersen", "Kahtrin", "Wellingtonstreet", 45, 72365, "Wellington", "Neuseeland", "6784354625", 26,"13.04.16 Kunde ist mit dem Kundendienst zufrieden");
		
		FactoryKunde.add("Kunde", "Principe", "Alisha", "Via Valenzia", 14, 14372, "Ceglie", "Italien", "234567290", 27, "14.03.15 Kunde war nicht erreichbar");
		
	}
}