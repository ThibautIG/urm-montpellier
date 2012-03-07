package BL;


public abstract class Teacher {
  private String id;

  private String firstName;

  private String lastName;

  private String password;

  private String phone;

  private String mail;

  private boolean superUser;

  private list<Teaching> myTeachings;

  /**
   * Charge l'enseignant qui a l'id donné en paramètre.
   */
  public abstract void load(String id) ;

  /**
   * Retourne la liste des enseignements de cet enseignant.
   */
  public abstract list<Teaching> getTeachings() ;

  /**
   * Retourne vrai si l'enseignant est le gestionnaire, faux sinon.
   */
  public boolean isSuperUser() {
	  	return superUser;
  }

  /**
   * Retourne la liste des réservations qui ont été faites par l'utilisateur et qui ont été validées (Qui ont reçu une salle). 
   */
  public abstract list<Booking> getValidBooking();
  
  public String toString() {
	  String result = new String;
	  result = id+" "+firstName+" "+lastName+" "+phone+" "+mail+" "+superUser;
	  Iterator i = myTeachings().iterator();
	  while(i.hasNext()) {
		  result+=((Teaching)i.next()).getId()+" ";
	  }
	  return result;
  }

}
