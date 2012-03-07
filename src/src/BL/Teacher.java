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
   * Charge l'enseignant qui a l'id donn� en param�tre.
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
   * Retourne la liste des r�servations qui ont �t� faites par l'utilisateur et qui ont �t� valid�es (Qui ont re�u une salle). 
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
