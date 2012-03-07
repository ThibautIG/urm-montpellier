package BL;


public abstract class PersistFactory 
{
  private static PersistFactory PF;

  /**
   * Retourne l'instance de la persistFactory.
   */
  public static PersistFactory getInstance()
  {
		if(PF==NULL) PF = new PersistFactoryJDBC();
		return PersistFactory;
  }

  /**
   * Renvoie un objet de type enseignant.
   */
  public abstract Teacher createTeacher();

  /**
   * Renvoie un objet de type enseignement.
   */
  public abstract Teaching createTeaching();

  /**
   * Renvoie un objet de type reservation.
   */
  public abstract Booking createBooking();

  /**
   * Renvoie un objet de type caractéristique.
   */
  public abstract Feature createFeature();

  /**
   * Renvoie un objet de type créneau horaire.
   */
  public abstract Schedule createSchedule();

  /**
   * Renvoie un objet de type gestionnaire.
   */
  public abstract Manager createManager();

}
