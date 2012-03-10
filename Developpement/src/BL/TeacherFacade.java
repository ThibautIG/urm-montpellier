package BL;

import java.util.ArrayList;


public class TeacherFacade {

	private Teacher user;
	private Manager manager;
	private Booking myBooking;

	public TeacherFacade() 
	{

	}

	/**
	 * Connecte l'utilisateur si id/pwd est valide
	 */
	public boolean connect(String nom, String pwd) 
	{
		boolean isConnected = false;

		this.user = PersistFactory.getInstance().createTeacher(); //crée un teacher
		try 
		{
			this.user.load(nom, pwd);
			System.out.println(this.user.isSuperUser());
			isConnected = true;
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("non connecté");
			isConnected = false;
			this.user = null;
		}


		return isConnected;

	}

	/**
	 * Retourne la liste des créneaux disponibles sous la forme d'une liste de String.
	 */
	String getSchedules() {
		return "null";
	}

	/**
	 * retourne la liste des caractéristiques disponibles dans une liste de String.
	 */
	String getFeatures() 
	{
		return "";
	}

	/**
	 * retourne la liste des enseignement de l'user (l'enseignant qui utilise l'application), dans une liste de String.
	 */
	ArrayList<String> getTeaching() 
	{
		return null;
	}

	/**
	 * Renvoie la liste des Réservations faites par l'enseignant qui sont validées.
	 */
	public ArrayList<String> getValidBooking(int week) 
	{
		ArrayList<Booking> booklist = new ArrayList<Booking>();
		try {
			booklist = user.getValidBooking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retourne vrai si l'utilisateur est le gestionnaire de l'emploi du temps, faux sinon.
	 */
	public boolean isSuperUser()
	{
		System.out.println(this.user.isSuperUser());
		if(this.user != null)
		{
			return this.user.isSuperUser();
		}
		else
		{
			return false;
		}
	}

	/**
	 * Valide définitivement la reservation, c'est à dire sauvegarde les données de celle-ci.
	 */
	void confirmBooking() {
	}

	/**
	 * Retourne le nombre de salles disponibles avec les caractéristiques, la date, le créneau et la capacité choisie.
	 */
	int checkFreeRooms() {

		return 0;
	}

}
