package BL;

public abstract class Schedule {

	protected String id;
	protected String startTime;
	protected String endTime;


	/**
	 * Charge le cr�neau avec l'id correspondant.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;

	/**
	 * Retourne l'id du cr�neau.
	 */
	public String getId() {
		return id;
	}

	public String toString() 
	{
		return startTime + " - " + endTime;
	}

}
