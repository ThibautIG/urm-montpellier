package BL;
import Persist.*;


public abstract class PersistFactory 
{
	private static PersistFactory PF;

	/**
	 * Retourne l'instance de la persistFactory.
	 */
	public static PersistFactory getInstance()
	{
		if(PF==null) PF = new PersistFactoryJDBC();
		return PF;
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
	 * Renvoie un objet de type caract�ristique.
	 */
	public abstract Feature createFeature();

	/**
	 * Renvoie un objet de type cr�neau horaire.
	 */
	public abstract Schedule createSchedule();

	/**
	 * Renvoie un objet de type gestionnaire.
	 */
	public abstract Manager createManager();

}
