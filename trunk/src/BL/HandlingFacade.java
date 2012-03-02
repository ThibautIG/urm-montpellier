
/**
 * 																																																																
 */
class HandlingFacade {
  public HandlingFacade() {
  }

  /**
   * Renvoie la liste de toutes les demandes de reservations 
   * des enseignants qui ne sont pas validees.
   */
  list <struct String> getAllUnvalidBookings() {
  }

  /**
   * Selectionne la r�servation avec la reference donn�e en param�tre.
   */
  void selectBooking(int reference) {
  }

  /**
   * retourne sous la forme d'une structure compos�e de strings toutes les informations sur le teacher, c'est � dire nom, pr�nom, t�l�phone, mail et enseignement.
   */
  struct string getBookingTeacherInfos() {
  }

  /**
   * Retourne la date de la r�servation selectionn�e.
   */
  String getSelectedBookingDate() {
  }

  /**
   * Retourne la listes de toutes les caract�ristiques disponibles.
   */
  list<string> getFeatures() {
  }

  /**
   * Retourne la liste des caract�ristiques de la r�servation selectionn�e.
   */
  list<string> getSelectedBookingFeatures() {
  }

  /**
   * Retourne la liste de tout les cr�neaux disponibles.
   */
  list<string> getSchedules() {
  }

  /**
   * Retourne le cr�neau de la r�servation selectionn�e.
   */
  String getSelectedBookingSchedule() {
  }

  /**
   * Retourne toutes les cr�neaux pour toutes les dates de la semaine pour lesquels il y a des salles de disponibles avec cette r�servation.
   */
  struct string getWeekValidSchedules() {
  }

  /**
   * Sauvegarde la r�servation et lui associe une salle.
   */
  void validBooking() {
  }

  /**
   * Supprime la r�servation.
   */
  void deleteBooking() {
  }

  /**
   * Remplace les donn�es dans la r�servation selectionn�e.
   */
  void changeBookingData(String date, String schedule, list<string> features) {
  }

  private Manager manager;

}
