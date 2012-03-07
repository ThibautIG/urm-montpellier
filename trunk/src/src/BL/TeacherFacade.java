package BL;


public class TeacherFacade {
  public TeacherFacade() {
  }

  /**
   * Connecte l'utilisateur si id/pwd est valide
   */
  public boolean connect(String id, String pwd) 
  {
	return false;
	  
  }

  /**
   * Retourne la liste des créneaux disponibles sous la forme d'une liste de String.
   */
  String getSchedules() {
	  return "null";
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
	  
	  return false;
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
	  
	  return 0;
  }

  private Teacher teacher;

  private Manager manager;

  private Booking myBooking;

}
