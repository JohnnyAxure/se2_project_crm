package SE2.CRM_System;

public interface IKunde {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getVorname();

	public abstract void setVorname(String vorname);

	public abstract String getStraße();

	public abstract void setStraße(String straße);

	public abstract int getHausnummer();

	public abstract void setHausnummer(int hausnummer);

	public abstract int getPostleitzahl();

	public abstract void setPostleitzahl(int postleitzahl);

	public abstract String getStadt();

	public abstract void setStadt(String stadt);

	public abstract String getLand();

	public abstract void setLand(String land);

	public abstract String getTelefon();

	public abstract void setTelefon(String telefon);

	public abstract int getKundennummer();

	public abstract void setKundennummer(int kundennummer);

	public abstract String getAll();

}
