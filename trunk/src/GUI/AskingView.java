
class AskingView {
  private String featuresSelected;

  private String scheduleSelected;

  private String dateSelected;

  private String teachingSelected;

  private int capacity;

  private String comments;

  AskingView() {
  }

  /**
   * Méthode qui écoute les événement sur les radios boutons de sélection du type de demande.
   */
  void selectRequestType() {
  }

  /**
   * Méthode qui écoute le widget pour la sélection d'un enseignement et sauvegarde l'enseignement choisi.
   */
  void selectTeaching() {
  }

  /**
   * écoute les événements du calendrier et sauvegarde la date choisie.
   */
  void selectDate() {
  }

  /**
   * écoute les événements sur la ComboBox de selection du créneau et sauvegarde le créneau choisi.
   */
  void selectSchedule() {
  }

  /**
   * Ajoute la caractéristique sélectionnée dans la liste de gauche à la liste de droite. Sauvegarde cette caractéristique.
   */
   addFeature() {
  }

  /**
   * écoute la boite d'éddition capacité et sauvegarde la donnée rentrée.
   */
  void setCapacity() {
  }

  /**
   * écoute la zone d'éddition et sauvegarde le contenu de celle-ci.
   */
  void setComments() {
  }

  /**
   * retourne le nombre de salles libres avec les paramètres de la réservation.
   */
  int checkFreeRooms() {
  }

  /**
   * Valide la réservation avec les paramètres choisis. Si un paramètre n'est pas sélectionné alors la validation renvoie une erreur.
   */
  void confirmBooking() {
  }

  private TeacherFacade account;

}
