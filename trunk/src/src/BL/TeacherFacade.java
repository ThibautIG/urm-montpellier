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
   * Retourne la liste des cr�neaux disponibles sous la forme d'une liste de String.
   */
  String getSchedules() {
  }

  /**
   * retourne la liste des caract�ristiques disponibles dans une liste de String.
   */
  String getFeatures() {
  }

  /**
   * retourne la liste des enseignement de l'user (l'enseignant qui utilise l'application), dans une liste de String.
   */
  list<string> getTeaching() {
  }

  /**
   * Renvoie la liste des R�servations faites par l'enseignant qui sont valid�es.
   */
  public list<Booking> getValidBooking(int week) {
  }

  /**
   * Retourne vrai si l'utilisateur est le gestionnaire de l'emploi du temps, faux sinon.
   */
  boolean isSuperUser() {
  }

  /**
   * Valide d�finitivement la reservation, c'est � dire sauvegarde les donn�es de celle-ci.
   */
  void confirmBooking() {
  }

  /**
   * Retourne le nombre de salles disponibles avec les caract�ristiques, la date, le cr�neau et la capacit� choisie.
   */
  int checkFreeRooms() {
  }

  private Teacher teacher;

  private Manager manager;

  private Booking myBooking;

}
