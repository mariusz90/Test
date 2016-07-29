package zagala.mariusz.classes;

public class Zakup {

	private int idK;
	private int idS;
	private int id;
	public Zakup()
	{
		setId(id);
		setIdK(idK);
		setIdS(idS);
	}
	public Zakup(int id,int idK, int idS)
	{
		setId(id);
		setIdK(idK);
		setIdS(idS);
		
	}
	/**
	 * @return the idK
	 */
	public int getIdK() {
		return idK;
	}
	/**
	 * @param idK the idK to set
	 */
	public void setIdK(int idK) {
		this.idK = idK;
	}
	/**
	 * @return the idS
	 */
	public int getIdS() {
		return idS;
	}
	/**
	 * @param idS the idS to set
	 */
	public void setIdS(int idS) {
		this.idS = idS;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + idK;
		result = prime * result + idS;
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
		Zakup other = (Zakup) obj;
		if (id != other.id)
			return false;
		if (idK != other.idK)
			return false;
		if (idS != other.idS)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zakup [idK=" + idK + ", idS=" + idS + ", id=" + id + "]";
	}
	
}
