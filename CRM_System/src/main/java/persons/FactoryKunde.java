package persons;


import mainFunctionality.Kundenliste;
/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/



/**
 * Factory class with the following methods
 *
 */
public class FactoryKunde extends Kundenliste{

	/**
	 * This method creates a new customer.
	 * The customer gets added to the customer List "listeDerKunden"
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
	public static void add(String type, String name, String vorname,
			String straße, int hausnummer, int postleitzahl, String stadt,
			String land, String telefon, int kundennummer,String notiz) {

		if (type.equals("Kunde")) {
			
		IKunde temp = new Kunde(type, name, vorname, straße, hausnummer, postleitzahl, stadt, land, telefon, kundennummer, notiz);
			
		Kundenliste.getListeDerKunden().add(temp);
						
			
		} 

	}
}