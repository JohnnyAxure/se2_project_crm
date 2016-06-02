package SE2.CRM_System;

import javafx.beans.property.SimpleStringProperty;

public class Kunde implements IKunde {

	String type;
	String Name;
	String Vorname;
	String Straße;
	int Hausnummer;
	int Postleitzahl;
	String Stadt;
	String Land;
	String Telefon;
	int Kundennummer;

	// String Email;

	public Kunde(String type, String Name, String Vorname, String Straße, int Hausnummer,
			int Postleitzahl, String Stadt, String Land, String Telefon,
			int Kundennummer) {
		this.type = type;
		this.Name = Name;
		this.Vorname = Vorname;
		this.Straße = Straße;
		this.Hausnummer = Hausnummer;
		this.Postleitzahl = Postleitzahl;
		this.Stadt = Stadt;
		this.Land = Land;
		this.Telefon = Telefon;
		this.Kundennummer = Kundennummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getName()22
	 */
	public String getName() {
		return Name;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setName(java.lang.String)
	 */
	public void setName(String name) {
		Name = name;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getVorname()
	 */
	public String getVorname() {
		return Vorname;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setVorname(java.lang.String)
	 */
	public void setVorname(String vorname) {
		Vorname = vorname;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getStraße()
	 */
	public String getStraße() {
		return Straße;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setStraße(java.lang.String)
	 */
	public void setStraße(String straße) {
		Straße = straße;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getHausnummer()
	 */
	public int getHausnummer() {
		return Hausnummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setHausnummer(int)
	 */
	public void setHausnummer(int hausnummer) {
		Hausnummer = hausnummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getPostleitzahl()
	 */
	public int getPostleitzahl() {
		return Postleitzahl;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setPostleitzahl(int)
	 */
	public void setPostleitzahl(int postleitzahl) {
		Postleitzahl = postleitzahl;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getStadt()
	 */
	public String getStadt() {
		return Stadt;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setStadt(java.lang.String)
	 */
	public void setStadt(String stadt) {
		Stadt = stadt;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getLand()
	 */
	public String getLand() {
		return Land;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setLand(java.lang.String)
	 */
	public void setLand(String land) {
		Land = land;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getTelefon()
	 */
	public String getTelefon() {
		return Telefon;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setTelefon(java.lang.String)
	 */
	public void setTelefon(String Telefon) {
		Telefon = Telefon;
	}
	

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getKundennummer()
	 */
	public int getKundennummer() {
		return Kundennummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#setKundennummer(int)
	 */
	public void setKundennummer(int kundennummer) {
		Kundennummer = kundennummer;
	}

	/* (non-Javadoc)
	 * @see SE2.CRM_System.IKunde#getAll()
	 */
	public String getAll() {
		return Name + "\n" + Vorname + "\n" + Straße + " " + Hausnummer + "\n"
				+ Postleitzahl + " " + Stadt + "\n" + Land + "\n" + Telefon;
	}
}
