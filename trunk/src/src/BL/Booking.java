package BL;


/**
 * 																																																																																																																																																																																																										
 */
abstract class Booking 
{
  private String id;

  private int capacity;

  private String date;

  private String comments;

  private String idSalle;

  /**
   * Crée une nouvelle réservation.
   */
   create() {
  }

  /**
   * Charge la réservation qui à pour id reference.
   */
  abstract  load(String reference) ;

  /**
   * Retourne le nombre de salles de disponibles pour les paramètres de cette réservation.
   */
  abstract int checkFreeRooms() ;

  /**
   * Retourne l'enseignement lié à cette réservation.
   */
  Teaching getTeaching() {
  }

  /**
   * Retourne la date de réservation.
   */
  String getDate() {
  }

  /**
   * Remplace la date de reservation.
   */
  void setDate(String date) {
  }

  /**
   * Retourne le créneau de réservation.
   */
  String getSchedule() {
  }

  /**
   * Remplace le créneau de réservation.
   */
   setSchedule(String schedule) {
  }

  /**
   * Retourne la liste des caractéristiques de la réservation.
   */
  list<string> getFeatures() {
  }

  /**
   * Remplace la liste des caractéristiques de la réservation.
   */
  void setFeatures(list<string> features) {
  }

  /**
   * Associe une salle à la réservation.
   */
  abstract  setSalle() ;

  /**
   * Sauvegarde la réservation.
   */
  abstract  save() ;

  private Schedule schedule;

  private Feature feature;

  private Teaching teaching;

}
