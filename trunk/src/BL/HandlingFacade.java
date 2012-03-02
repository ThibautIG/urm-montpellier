
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
   * Selectionne la réservation avec la reference donnée en paramètre.
   */
  void selectBooking(int reference) {
  }

  /**
   * retourne sous la forme d'une structure composée de strings toutes les informations sur le teacher, c'est à dire nom, prénom, téléphone, mail et enseignement.
   */
  struct string getBookingTeacherInfos() {
  }

  /**
   * Retourne la date de la réservation selectionnée.
   */
  String getSelectedBookingDate() {
  }

  /**
   * Retourne la listes de toutes les caractéristiques disponibles.
   */
  list<string> getFeatures() {
  }

  /**
   * Retourne la liste des caractéristiques de la réservation selectionnée.
   */
  list<string> getSelectedBookingFeatures() {
  }

  /**
   * Retourne la liste de tout les créneaux disponibles.
   */
  list<string> getSchedules() {
  }

  /**
   * Retourne le créneau de la réservation selectionnée.
   */
  String getSelectedBookingSchedule() {
  }

  /**
   * Retourne toutes les créneaux pour toutes les dates de la semaine pour lesquels il y a des salles de disponibles avec cette réservation.
   */
  struct string getWeekValidSchedules() {
  }

  /**
   * Sauvegarde la réservation et lui associe une salle.
   */
  void validBooking() {
  }

  /**
   * Supprime la réservation.
   */
  void deleteBooking() {
  }

  /**
   * Remplace les données dans la réservation selectionnée.
   */
  void changeBookingData(String date, String schedule, list<string> features) {
  }

  private Manager manager;

}
