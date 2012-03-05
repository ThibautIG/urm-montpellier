package BL;


protected class TeacherFacade {
  TeacherFacade() {
  }

  /**
   * Connecte l'utilisateur si id/pwd est valide
   */
  public void connect(String id, String pwd) {
  }

  /**
   * Retourne la liste des créneaux disponibles sous la forme d'une liste de String.
   */
  String getSchedules() {
  }

  /**
   * retourne la liste des caractéristiques disponibles dans une liste de String.
   */
  String getFeatures() {
  }

  /**
   * retourne la liste des enseignement de l'user (l'enseignant qui utilise l'application), dans une liste de String.
   */
  list<string> getTeaching() {
  }

  /**
   * Renvoie la liste des Réservations faites par l'enseignant qui sont validées.
   */
  public list<Booking> getValidBooking(int week) {
  }

  /**
   * Retourne vrai si l'utilisateur est le gestionnaire de l'emploi du temps, faux sinon.
   */
  boolean isSuperUser() {
  }

  /**
   * Valide définitivement la reservation, c'est à dire sauvegarde les données de celle-ci.
   */
  void confirmBooking() {
  }

  /**
   * Retourne le nombre de salles disponibles avec les caractéristiques, la date, le créneau et la capacité choisie.
   */
  int checkFreeRooms() {
  }

  private Teacher teacher;

  private Manager manager;

  private Booking myBooking;

}
