package BL;


public abstract class PersistFactory 
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
  protected abstract Teacher createTeacher();

  /**
   * Renvoie un objet de type enseignement.
   */
  protected abstract Teaching createTeaching();

  /**
   * Renvoie un objet de type reservation.
   */
  protected abstract Booking createBooking();

  /**
   * Renvoie un objet de type caractéristique.
   */
  protected abstract Feature createFeature();

  /**
   * Renvoie un objet de type créneau horaire.
   */
  protected abstract Schedule createSchedule();

  /**
   * Renvoie un objet de type gestionnaire.
   */
  protected abstract Manager createManager();

}
