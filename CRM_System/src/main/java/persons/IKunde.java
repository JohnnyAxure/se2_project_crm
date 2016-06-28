package persons;
/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/

import javafx.scene.web.HTMLEditor;

/**
 * Interface class that has the following methods.
 *
 */
public interface IKunde {
	
	/**
	 * @return the type.
	 */
	public String getType();

	/**
	 * @param type the customers type
	 */
	public void setType(String type);

	/**
	 * @return the customers surname
	 */
	public  String getName();

	/**
	 * @param name the customers surname
	 */
	public void setName(String name);

	/**
	 * @return the customers first name
	 */
	public String getVorname();

	/**
	 * @param vorname the customers first name
	 */
	public void setVorname(String vorname);

	/**
	 * @return the street, in which the customer lives
	 */
	public  String getStraße();

	/**
	 * @param straße street, in which the customer lives
	 */
	public  void setStraße(String straße);

	/**
	 * @return the house number 
	 */
	public  int getHausnummer();

	/**
	 * @param hausnummer the house number
	 */
	public void setHausnummer(int hausnummer);

	/**
	 * @return the zip code of the city, where the customer lives
	 */
	public  int getPostleitzahl();

	/**
	 * @param postleitzahl zip code of the city, where the customer lives
	 */
	public void setPostleitzahl(int postleitzahl);

	/**
	 * @return the city, where the customer lives
	 */
	public  String getStadt();

	/**
	 * @param stadt the city, where the customer lives
	 */
	public  void setStadt(String stadt);

	/**
	 * @return the country, where the customer lives
	 */
	public  String getLand();

	/**
	 * @param land the country, where the customer lives
	 */
	public  void setLand(String land);

	/**
	 * @return the customers phone number 
	 */
	public String getTelefon();

	/**
	 * @param telefon the customers phone number 
	 */
	public void setTelefon(String telefon);

	/**
	 * @return the customer number
	 */
	public  int getKundennummer();

	/**
	 * @param kundennummer the customer number
	 */
	public void setKundennummer(int kundennummer);
	
	/**
	 * @return notes regarding the customer
	 */
	public HTMLEditor getNotiz();
	
	/**
	 * @param notiz notes regarding the customer
	 */
	public void setNotiz(HTMLEditor notiz);

	/**
	 * @return all parameters of customer
	 */
	public  String getAll();

}