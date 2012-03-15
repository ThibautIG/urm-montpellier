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
		String result = new String();
		if(startTime.charAt(1) == 'h')
		{
			result = result+startTime.subSequence(0,4);
		}
		else
		{
			result = result+startTime.subSequence(0,5);
		}
		
		result = result + " - ";
		
		if(endTime.charAt(1) == 'h')
		{
			result = result+endTime.subSequence(0,4);
		}
		else
		{
			result = result+endTime.subSequence(0,5);
		}
		
		return result;
	}

}
