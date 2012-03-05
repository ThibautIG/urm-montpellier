package BL;


abstract class Teacher {
  private String id;

  private String firstName;

  private String lastName;

  private String password;

  private String phone;

  private String mail;

  private boolean superUser;

  /**
   * Charge l'enseignant qui a l'id donn� en param�tre.
   */
  abstract  load() ;

  /**
   * Retourne la liste des enseignements de cet enseignant.
   */
  abstract list<Teaching> getTeachings() ;

  /**
   * Retourne vrai si l'enseignant est le gestionnaire, faux sinon.
   */
  public boolean isSuperUser() {
  }

  /**
   * Retourne la liste des r�servations qui ont �t� faites par l'utilisateur et qui ont �t� valid�es (Qui ont re�u une salle). 
   */
  list<Booking> getValidBooking() {
  }

  private <Teaching> myTeachings;

}
