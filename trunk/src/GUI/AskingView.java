
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
   * M�thode qui �coute les �v�nement sur les radios boutons de s�lection du type de demande.
   */
  void selectRequestType() {
  }

  /**
   * M�thode qui �coute le widget pour la s�lection d'un enseignement et sauvegarde l'enseignement choisi.
   */
  void selectTeaching() {
  }

  /**
   * �coute les �v�nements du calendrier et sauvegarde la date choisie.
   */
  void selectDate() {
  }

  /**
   * �coute les �v�nements sur la ComboBox de selection du cr�neau et sauvegarde le cr�neau choisi.
   */
  void selectSchedule() {
  }

  /**
   * Ajoute la caract�ristique s�lectionn�e dans la liste de gauche � la liste de droite. Sauvegarde cette caract�ristique.
   */
   addFeature() {
  }

  /**
   * �coute la boite d'�ddition capacit� et sauvegarde la donn�e rentr�e.
   */
  void setCapacity() {
  }

  /**
   * �coute la zone d'�ddition et sauvegarde le contenu de celle-ci.
   */
  void setComments() {
  }

  /**
   * retourne le nombre de salles libres avec les param�tres de la r�servation.
   */
  int checkFreeRooms() {
  }

  /**
   * Valide la r�servation avec les param�tres choisis. Si un param�tre n'est pas s�lectionn� alors la validation renvoie une erreur.
   */
  void confirmBooking() {
  }

  private TeacherFacade account;

}
