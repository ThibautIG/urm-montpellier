package BL;


public abstract class Manager {
  /**
   * retourne une liste de toutes les caractéristiques existantes.
   */
  abstract list<Feature> getFeatures() ;

  /**
   * retourne une liste de tous les créneaux existants.
   */
  abstract list<Schedule> getSchedules() ;

  /**
   * Retourne la liste de toutes les réservations qui ne sont pas encore validées, c'est à dire pour lesquelles aucune salle n'est attribuée.
   */
  abstract list<Booking> getAllUnvalidBookings() ;

  /**
   * Ecoute les événements sur le tableau, lors d'un clique sur celui-ci enregistre la réservation sélectionné puis affiche toutes ses informations.
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
   * Retourne le créneau de la réservation selectionnée.
   */
  String getSelectedBookingSchedule() {
  }

  /**
   * Retourne sous forme de liste de structure les dates et créneaux pour lesquelles il y aucune salle libre avec les paramètre de la réservation selectionnée.
   */
  abstract list struct string getWeekUnvalidSchedules() ;

  /**
   * Remplace l'ancienne date de la reservation par la nouvelle date.
   */
  void setSelectedBookingDate(String date) {
  }

  /**
   * Remplace l'ancien créneau de la reservation par le nouveau créneau.
   */
  void setSelectedBookingSchedule(String schedule) {
  }

  /**
   * Remplace les anciennes caractéristiques de la reservation par les nouvelles.
   */
  void setSelectedBookingFeatures(list<String> features) {
  }

  /**
   * Sauvegarde la réservation selectionnée et lui associe une salle.
   */
  void saveSelectedBooking() {
  }

  /**
   * Supprime la réservation selectionnée.
   */
  abstract void deleteSelectedBooking() ;

  private <Feature> allFeatures;

  private <Schedule> allSchedules;

  private <Booking> allBookings;

  private Booking selectedBooking;

}
