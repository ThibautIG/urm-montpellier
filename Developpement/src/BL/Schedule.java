package BL;

public abstract class Schedule 
{
	protected String id;
	protected String startTime;
	protected String endTime;

	/**
	 * Charge le créneau avec l'id correspondant.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception;
	
	public void create(String id, String startTime, String endTime)
	{
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/**
	 * Retourne l'id du créneau.
	 */
	public String getId() 
	{
		return this.id;
	}

	public String toString() 
	{
		return startTime + " - " + endTime;
	}

}
