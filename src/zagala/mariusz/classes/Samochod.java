package zagala.mariusz.classes;

//id, marka, kolor, cena, pojemnosc, przebieg, rokProdukcji, czyKlimatyzacja, czyElektryczneSzyby, czyNowy 

public class Samochod {
	private int id;
	private String marka;
	private String kolor;
	private double cena;
	private double pojemnosc;
	private double przebieg;
	private int rokProdukcji;
	private boolean czyKlimatyzacja;
	private boolean czyElektryczneSzyby;
	private boolean czyNowy;
	
	public Samochod()
	{
		
	}
	public Samochod(int id, String marka, String kolor, double cena, double pojemnosc, double przebieg, int rokProdukcji, boolean czyKlimatyzacja, 
	boolean czyElektryczneSzyby, boolean czyNowy)
	{
		setCena(cena);
		setId(id);
		setMarka(marka);
		setKolor(kolor);
		setPojemnosc(pojemnosc);
		setPrzebieg(przebieg);
		setRokProdukcji(rokProdukcji);
		setCzyKlimatyzacja(czyKlimatyzacja);
		setCzyElektryczneSzyby(czyElektryczneSzyby);
		setCzyNowy(czyNowy);
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the marka
	 */
	public String getMarka() {
		return marka;
	}
	/**
	 * @param marka the marka to set
	 */
	public void setMarka(String marka) {
		this.marka = marka;
	}
	/**
	 * @return the kolor
	 */
	public String getKolor() {
		return kolor;
	}
	/**
	 * @param kolor the kolor to set
	 */
	public void setKolor(String kolor) {
		this.kolor = kolor;
	}
	/**
	 * @return the cena
	 */
	public double getCena() {
		return cena;
	}
	/**
	 * @param cena the cena to set
	 */
	public void setCena(double cena) {
		this.cena = cena;
	}
	/**
	 * @return the pojemnosc
	 */
	public double getPojemnosc() {
		return pojemnosc;
	}
	/**
	 * @param pojemnosc the pojemnosc to set
	 */
	public void setPojemnosc(double pojemnosc) {
		this.pojemnosc = pojemnosc;
	}
	/**
	 * @return the przebieg
	 */
	public double getPrzebieg() {
		return przebieg;
	}
	/**
	 * @param przebieg the przebieg to set
	 */
	public void setPrzebieg(double przebieg) {
		this.przebieg = przebieg;
	}
	/**
	 * @return the rokProdukcji
	 */
	public int getRokProdukcji() {
		return rokProdukcji;
	}
	/**
	 * @param rokProdukcji the rokProdukcji to set
	 */
	public void setRokProdukcji(int rokProdukcji) {
		this.rokProdukcji = rokProdukcji;
	}
	/**
	 * @return the czyKlimatyzacja
	 */
	public boolean isCzyKlimatyzacja() {
		return czyKlimatyzacja;
	}
	/**
	 * @param czyKlimatyzacja the czyKlimatyzacja to set
	 */
	public void setCzyKlimatyzacja(boolean czyKlimatyzacja) {
		this.czyKlimatyzacja = czyKlimatyzacja;
	}
	/**
	 * @return the czyElektryczneSzyby
	 */
	public boolean isCzyElektryczneSzyby() {
		return czyElektryczneSzyby;
	}
	/**
	 * @param czyElektryczneSzyby the czyElektryczneSzyby to set
	 */
	public void setCzyElektryczneSzyby(boolean czyElektryczneSzyby) {
		this.czyElektryczneSzyby = czyElektryczneSzyby;
	}
	/**
	 * @return the czyNowy
	 */
	public boolean isCzyNowy() {
		return czyNowy;
	}
	/**
	 * @param czyNowy the czyNowy to set
	 */
	public void setCzyNowy(boolean czyNowy) {
		this.czyNowy = czyNowy;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cena);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (czyElektryczneSzyby ? 1231 : 1237);
		result = prime * result + (czyKlimatyzacja ? 1231 : 1237);
		result = prime * result + (czyNowy ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + ((kolor == null) ? 0 : kolor.hashCode());
		result = prime * result + ((marka == null) ? 0 : marka.hashCode());
		temp = Double.doubleToLongBits(pojemnosc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(przebieg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rokProdukcji;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Samochod other = (Samochod) obj;
		if (Double.doubleToLongBits(cena) != Double.doubleToLongBits(other.cena))
			return false;
		if (czyElektryczneSzyby != other.czyElektryczneSzyby)
			return false;
		if (czyKlimatyzacja != other.czyKlimatyzacja)
			return false;
		if (czyNowy != other.czyNowy)
			return false;
		if (id != other.id)
			return false;
		if (kolor == null) {
			if (other.kolor != null)
				return false;
		} else if (!kolor.equals(other.kolor))
			return false;
		if (marka == null) {
			if (other.marka != null)
				return false;
		} else if (!marka.equals(other.marka))
			return false;
		if (Double.doubleToLongBits(pojemnosc) != Double.doubleToLongBits(other.pojemnosc))
			return false;
		if (Double.doubleToLongBits(przebieg) != Double.doubleToLongBits(other.przebieg))
			return false;
		if (rokProdukcji != other.rokProdukcji)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Samochod [id=" + id + ", marka=" + marka + ", kolor=" + kolor + ", cena=" + cena + ", pojemnosc="
				+ pojemnosc + ", przebieg=" + przebieg + ", rokProdukcji=" + rokProdukcji + ", czyKlimatyzacja="
				+ czyKlimatyzacja + ", czyElektryczneSzyby=" + czyElektryczneSzyby + ", czyNowy=" + czyNowy + "]";
	}
	
}
