package BL;


/**
 * 																																																																																																																																																																																																										
 */
public abstract class Booking 
{
  private String id;

  private int capacity;

  private String date;

  private String comments;

  private String idSalle;

  private Schedule schedule;

  private list<Feature> features;

  private Teaching teaching;

  /**
   * Crée une nouvelle réservation.
   */
  public static Booking create() {
  }

  /**
   * Charge la réservation qui à pour id reference.
   */
  public abstract void load(String reference) ;

  /**
   * Retourne le nombre de salles de disponibles pour les paramètres de cette réservation.
   */
  public abstract int checkFreeRooms() ;

  /**
   * Retourne l'enseignement lié à cette réservation.
   */
  public Teaching getTeaching() {
	  	return teaching;
  }

  /**
   * Retourne la date de réservation.
   */
  public String getDate() {
	  	return date;
  }

  /**
   * Remplace la date de reservation.
   */
  public void setDate(String date) {
	  	this.date=date;
  }

  /**
   * Retourne le créneau de réservation.
   */
  public String getSchedule() {
	  	return schedule;
  }

  /**
   * Remplace le créneau de réservation.
   */
  public void setSchedule(String schedule) {
	  	this.schedule = schedule;
  }

  /**
   * Retourne la liste des caractéristiques de la réservation.
   */
  public list<string> getFeatures() {
	  	return features;
  }

  /**
   * Remplace la liste des caractéristiques de la réservation.
   */
  public void setFeatures(list<string> features) {
	  this.features = features;
  }

  /**
   * Associe une salle à la réservation.
   */
  public abstract void setSalle() ;

  /**
   * Sauvegarde la réservation.
   */
  public abstract boolean save() ;
  
  public String getTeacherInfos() {
	  return teaching.getTeacherInfos();
  }
  
  public String getStringSchedule() {
	  return schedule.toString();
  }

}
