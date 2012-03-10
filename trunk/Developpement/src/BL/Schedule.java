package BL;

public abstract class Schedule {

	protected String id;
	protected String startTime;
	protected String endTime;


	/**
	 * Charge le créneau avec l'id correspondant.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;

	/**
	 * Retourne l'id du créneau.
	 */
	public String getId() {
		return id;
	}

	public String toString() 
	{
		return startTime + " - " + endTime;
	}

}
