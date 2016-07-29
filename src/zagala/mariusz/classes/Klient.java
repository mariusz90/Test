package zagala.mariusz.classes;

	public class Klient {
	private String imie;
	private String nazwisko;
	private String miejsceZamieszkania;
	private int id;
	private int nrTelefonu;
	
	
	public Klient(int id, String imie, String nazwisko, String miejsceZamieszkania, int nrTelefonu)
	{
		setId(id);
		setImie(imie);
		setNazwisko(nazwisko);
		setMiejsceZamieszkania(miejsceZamieszkania);
		setNrTelefonu(nrTelefonu);
	}
	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}

	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}

	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}

	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	/**
	 * @return the miejsceZamieszkania
	 */
	public String getMiejsceZamieszkania() {
		return miejsceZamieszkania;
	}

	/**
	 * @param miejsceZamieszkania the miejsceZamieszkania to set
	 */
	public void setMiejsceZamieszkania(String miejsceZamieszkania) {
		this.miejsceZamieszkania = miejsceZamieszkania;
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
	 * @return the nrTelefonu
	 */
	public int getNrTelefonu() {
		return nrTelefonu;
	}

	/**
	 * @param nrTelefonu the nrTelefonu to set
	 */
	public void setNrTelefonu(int nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((imie == null) ? 0 : imie.hashCode());
		result = prime * result + ((miejsceZamieszkania == null) ? 0 : miejsceZamieszkania.hashCode());
		result = prime * result + ((nazwisko == null) ? 0 : nazwisko.hashCode());
		result = prime * result + nrTelefonu;
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
		Klient other = (Klient) obj;
		if (id != other.id)
			return false;
		if (imie == null) {
			if (other.imie != null)
				return false;
		} else if (!imie.equals(other.imie))
			return false;
		if (miejsceZamieszkania == null) {
			if (other.miejsceZamieszkania != null)
				return false;
		} else if (!miejsceZamieszkania.equals(other.miejsceZamieszkania))
			return false;
		if (nazwisko == null) {
			if (other.nazwisko != null)
				return false;
		} else if (!nazwisko.equals(other.nazwisko))
			return false;
		if (nrTelefonu != other.nrTelefonu)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Klient [imie=" + imie + ", nazwisko=" + nazwisko + ", miejsceZamieszkania=" + miejsceZamieszkania
				+ ", id=" + id + ", nrTelefonu=" + nrTelefonu + "]";
	}
	
}
