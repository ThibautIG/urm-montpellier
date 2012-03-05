package BL;


public abstract class Manager {
  /**
   * retourne une liste de toutes les caract�ristiques existantes.
   */
  abstract list<Feature> getFeatures() ;

  /**
   * retourne une liste de tous les cr�neaux existants.
   */
  abstract list<Schedule> getSchedules() ;

  /**
   * Retourne la liste de toutes les r�servations qui ne sont pas encore valid�es, c'est � dire pour lesquelles aucune salle n'est attribu�e.
   */
  abstract list<Booking> getAllUnvalidBookings() ;

  /**
   * Ecoute les �v�nements sur le tableau, lors d'un clique sur celui-ci enregistre la r�servation s�lectionn� puis affiche toutes ses informations.
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
   * Retourne le cr�neau de la r�servation selectionn�e.
   */
  String getSelectedBookingSchedule() {
  }

  /**
   * Retourne sous forme de liste de structure les dates et cr�neaux pour lesquelles il y aucune salle libre avec les param�tre de la r�servation selectionn�e.
   */
  abstract list struct string getWeekUnvalidSchedules() ;

  /**
   * Remplace l'ancienne date de la reservation par la nouvelle date.
   */
  void setSelectedBookingDate(String date) {
  }

  /**
   * Remplace l'ancien cr�neau de la reservation par le nouveau cr�neau.
   */
  void setSelectedBookingSchedule(String schedule) {
  }

  /**
   * Remplace les anciennes caract�ristiques de la reservation par les nouvelles.
   */
  void setSelectedBookingFeatures(list<String> features) {
  }

  /**
   * Sauvegarde la r�servation selectionn�e et lui associe une salle.
   */
  void saveSelectedBooking() {
  }

  /**
   * Supprime la r�servation selectionn�e.
   */
  abstract void deleteSelectedBooking() ;

  private <Feature> allFeatures;

  private <Schedule> allSchedules;

  private <Booking> allBookings;

  private Booking selectedBooking;

}
