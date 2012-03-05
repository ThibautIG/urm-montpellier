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
   * Charge l'enseignant qui a l'id donné en paramètre.
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
   * Retourne la liste des réservations qui ont été faites par l'utilisateur et qui ont été validées (Qui ont reçu une salle). 
   */
  list<Booking> getValidBooking() {
  }

  private <Teaching> myTeachings;

}
