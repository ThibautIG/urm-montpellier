package BL;


abstract class PersistFactory 
{
  private static PersistFactory PersistFactory;

  /**
   * Retourne l'instance de la persistFactory.
   */
  public static PersistFactory getInstance()
  {
	  return PersistFactory;
  }

  /**
   * Renvoie un objet de type enseignant.
   */
  abstract Teacher createTeacher();

  /**
   * Renvoie un objet de type enseignement.
   */
  abstract Teaching createTeaching();

  /**
   * Renvoie un objet de type reservation.
   */
  abstract Booking createBooking();

  /**
   * Renvoie un objet de type caract�ristique.
   */
  abstract Feature createFeature();

  /**
   * Renvoie un objet de type cr�neau horaire.
   */
  abstract Schedule createSchedule();

  /**
   * Renvoie un objet de type gestionnaire.
   */
  abstract Manager createManager();

}
