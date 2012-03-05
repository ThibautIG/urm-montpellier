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
   * Cr�e une nouvelle r�servation.
   */
   create() {
  }

  /**
   * Charge la r�servation qui � pour id reference.
   */
  abstract  load(String reference) ;

  /**
   * Retourne le nombre de salles de disponibles pour les param�tres de cette r�servation.
   */
  abstract int checkFreeRooms() ;

  /**
   * Retourne l'enseignement li� � cette r�servation.
   */
  Teaching getTeaching() {
  }

  /**
   * Retourne la date de r�servation.
   */
  String getDate() {
  }

  /**
   * Remplace la date de reservation.
   */
  void setDate(String date) {
  }

  /**
   * Retourne le cr�neau de r�servation.
   */
  String getSchedule() {
  }

  /**
   * Remplace le cr�neau de r�servation.
   */
   setSchedule(String schedule) {
  }

  /**
   * Retourne la liste des caract�ristiques de la r�servation.
   */
  list<string> getFeatures() {
  }

  /**
   * Remplace la liste des caract�ristiques de la r�servation.
   */
  void setFeatures(list<string> features) {
  }

  /**
   * Associe une salle � la r�servation.
   */
  abstract  setSalle() ;

  /**
   * Sauvegarde la r�servation.
   */
  abstract  save() ;

  private Schedule schedule;

  private Feature feature;

  private Teaching teaching;

}
