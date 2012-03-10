package BL;

public abstract class Feature 
{
	protected String id;
	protected String name;

	/**
	 * Chage la caractéristique correspondant à l'id donné en paramètre.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;

	/**
	 * Retourne l'id de la caractéristique.
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
