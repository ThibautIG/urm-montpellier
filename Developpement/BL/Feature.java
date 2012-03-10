package BL;

public abstract class Feature 
{
	protected String id;
	protected String name;

	/**
	 * Chage la caract�ristique correspondant � l'id donn� en param�tre.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;

	/**
	 * Retourne l'id de la caract�ristique.
	 */
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
