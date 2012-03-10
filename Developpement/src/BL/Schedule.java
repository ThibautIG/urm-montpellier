package BL;

public abstract class Schedule {
  private String id;

  private String endTime;

  private String startTime;

  /**
   * Charge le créneau avec l'id correspondant.
   */
  public abstract void load(String id) ;

  /**
   * Retourne l'id du créneau.
   */
  public String getId() {
	  	return id;
  }
  
  public String toString() {
	  return id+" "+startTime+"-"+endTime;
  }

}
