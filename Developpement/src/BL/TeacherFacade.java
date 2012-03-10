package BL;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;


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

		this.user = PersistFactory.getInstance().createTeacher(); //cr�e un teacher
		try 
		{
			this.user.load(nom, pwd);
			System.out.println(this.user.isSuperUser());
			isConnected = true;
		} catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("non connect�");
			isConnected = false;
			this.user = null;
		}


		return isConnected;

	}

	/**
	 * Retourne la liste des cr�neaux disponibles sous la forme d'une liste de String.
	 */
	public String[] getSchedules() 
	{
		String[] s =  {"8h00 - 9h30", "9h45 - 11h15"};
		return s;
	}

	/**
	 * retourne la liste des caract�ristiques disponibles dans une liste de String.
	 */
	public String[] getFeatures() 
	{
		String[] s =  {"R�troprojecteur", "Amphi"};
		return s;
	}

	/**
	 * retourne la liste des enseignement de l'user (l'enseignant qui utilise l'application), dans une liste de String.
	 */
	public String[] getTeaching() 
	{
		String[] s = {"BDRO", "Graphe"};
		return s;
	}

	/**
	 * Renvoie la liste des R�servations faites par l'enseignant qui sont valid�es.
	 */
	public ArrayList<ArrayList<String>> getValidBooking(int week) 
	{
		int i=0;
		/* liste de liste de string */
		ArrayList<ArrayList<String>> resaValidesString = new ArrayList<ArrayList<String>>();
		ArrayList<String> resaString = new ArrayList<String>();
		ArrayList<Booking> resaValides = new ArrayList<Booking>();
		Booking booking;
		
		try {
			resaValides = user.getValidBooking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (i=0; i<resaValides.size(); i++){
			booking = resaValides.get(i);
			resaString.add(booking.getDate());
			resaString.add(booking.getStringSchedule());
			resaString.add(booking.getTeacherInfos());
			resaString.add(booking.getRoom());
			//resaString.add(booking.getFieldString());
		}
		return resaValidesString;
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
	 * Valide d�finitivement la reservation, c'est � dire sauvegarde les donn�es de celle-ci.
	 */
	public void confirmBooking(String teaching, Date d, String sc, Enumeration<String> fts, int capacity, String comments) 
	{
		
	}

	/**
	 * Retourne le nombre de salles disponibles avec les caract�ristiques, la date, le cr�neau et la capacit� choisie.
	 */
	public int checkFreeRooms(Date d, String sc, Enumeration<String> fts, int capacity) 
	{
		return 1;
	}

}
