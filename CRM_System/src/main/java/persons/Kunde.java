package persons;



/**
* The CRM_System program implements an application that
* organizes customers 
*
* @author  ss401 , jh170 , bb071
* @version 1.0
* @since   2016.06.28
*/

/**
 * Represents a customer.
 * A customer can be edited and deleted 
 * 
 * Hinweis: Die Klasse mussten wir leider public lassen, 
 *          da wir sonst keine neu Instanz eines Kunden in der Factory Klasse anlegen können
 */
public class Kunde implements IKunde {

	public String type;
	public String name;
	public String vorname;
	public String straße;
	public int hausnummer;
	public int postleitzahl;
	public String stadt;
	public String land;
	public String telefon;
	public int kundennummer;
	public String notiz;
	
	

	

	/**
	 * Creates a new customer with all the parameters.
	 * @param type  The type of our person. In this case: customer
	 * @param name  surname of this customer
	 * @param vorname first name of the customer
	 * @param straße  street in which the customer lives
	 * @param hausnummer house number 
	 * @param postleitzahl zip code of the city, where the customer lives
	 * @param stadt city, in which the customer lives
	 * @param land  country, in which the customer lives
	 * @param telefon telephone number from the customer
	 * @param kundennummer the customer number
	 * @param notiz notes regarding the customer
	 */
	public Kunde(String type, String name, String vorname, String straße, int hausnummer,
			int postleitzahl, String stadt, String land, String telefon,
			int kundennummer,String notiz) {
		this.type = type;
		this.name = name;
		this.vorname = vorname;
		this.straße = straße;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.stadt = stadt;
		this.land = land;
		this.telefon = telefon;
		this.kundennummer = kundennummer;
		this.notiz = notiz;
	}
	
	

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getName()22
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setName(java.lang.String)
	 */
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getVorname()
	 */
	public String getVorname() {
		return vorname;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setVorname(java.lang.String)
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getStraße()
	 */
	public String getStraße() {
		return straße;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setStraße(java.lang.String)
	 */
	public void setStraße(String straße) {
		this.straße = straße;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getHausnummer()
	 */
	public int getHausnummer() {
		return hausnummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setHausnummer(int)
	 */
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getPostleitzahl()
	 */
	public int getPostleitzahl() {
		return postleitzahl;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setPostleitzahl(int)
	 */
	public void setPostleitzahl(int postleitzahl) {
		this.postleitzahl = postleitzahl;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getStadt()
	 */
	public String getStadt() {
		return stadt;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setStadt(java.lang.String)
	 */
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getLand()
	 */
	public String getLand() {
		return land;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setLand(java.lang.String)
	 */
	public void setLand(String land) {
		this.land = land;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getTelefon()
	 */
	public String getTelefon() {
		return telefon;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setTelefon(java.lang.String)
	 */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getKundennummer()
	 */
	public int getKundennummer() {
		return kundennummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setKundennummer(int)
	 */
	public void setKundennummer(int kundennummer) {
		this.kundennummer = kundennummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getNotiz()
	 */
	public String getNotiz() {
		return notiz;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setNotiz(HTMLEditor)
	 */
	public void setNotiz(String notiz) {
		this.notiz = notiz;
	}
	
	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getType()
	 */
	@Override
	public String getType() {
		
		return type;
	}


	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setType(type)
	 */
	@Override
	public void setType(String type) {
		this.type = type;
		
	}
	

	
	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getAll()
	 */
	public String getAll() {
		return name + "\n" + vorname + "\n" + straße + " " + hausnummer + "\n"
				+ postleitzahl + " " + stadt + "\n" + land + "\n" + telefon;
	}







}