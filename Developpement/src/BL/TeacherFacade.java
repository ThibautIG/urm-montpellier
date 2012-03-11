package BL;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;


public class TeacherFacade 
{
	private Teacher user;
	private Manager manager;
	private Booking myBooking;

	public TeacherFacade() 
	{
		this.manager = PersistFactory.getInstance().createManager();
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
			//e.printStackTrace();
			System.out.println("non connecté");
			isConnected = false;
			this.user = null;
		}

		return isConnected;

	}

	/**
	 * Retourne la liste des créneaux disponibles sous la forme d'une liste de String.
	 */
	public ArrayList<String> getSchedules() 
	{
		ArrayList<Schedule> scs;
		ArrayList<String> als = new ArrayList<String>();
		try {
			scs = this.manager.getSchedules();
			
			for (int i=0; i<scs.size(); i++)
			{
				als.add(scs.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return als;
	}

	/**
	 * retourne la liste des caractéristiques disponibles dans une liste de String.
	 */
	public String[] getFeatures() 
	{
		String[] s = {""};
		return s;
	}

	/**
	 * retourne la liste des enseignement de l'user (l'enseignant qui utilise l'application), dans une liste de String.
	 */
	public ArrayList<String> getTeaching() 
	{
		ArrayList<Teaching> scs;
		ArrayList<String> alt = new ArrayList<String>();
		try {
			scs = this.user.getTeachings();
			
			for (int i=0; i<scs.size(); i++)
			{
				alt.add(scs.get(i).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alt;
	}

	/**
	 * Renvoie la liste des Réservations faites par l'enseignant qui sont validées.
	 */
	public ArrayList<ArrayList<String>> getValidBooking(int week) 
	{
		int i=0;
		/* liste de liste de string */
		ArrayList<ArrayList<String>> resaValidesString = new ArrayList<ArrayList<String>>();
		ArrayList<String> resaString;
		ArrayList<Booking> resaValides = new ArrayList<Booking>();
		Booking booking;
		
		try {
			resaValides = user.getValidBooking();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (i=0; i<resaValides.size(); i++){
			
			booking = resaValides.get(i);
		
//			System.out.println(booking.getDate());
//			System.out.println(booking.getStringSchedule());
//			System.out.println(booking.getRoom());
//			System.out.println(booking.getField());
//			System.out.println("");
			
			resaString = new ArrayList<String>();
			resaString.add(booking.getDate());
			resaString.add(booking.getStringSchedule());
			resaString.add(booking.getRoom());
			resaString.add(booking.getField());
			
			resaValidesString.add(resaString);
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
	 * Valide définitivement la reservation, c'est à dire sauvegarde les données de celle-ci.
	 * @param comments 
	 * @param capacity 
	 * @param featuresSelected 
	 * @param scheduleSelected 
	 * @param dateSelected 
	 * @param teachingSelected 
	 */
	public void confirmBooking(String teachingSelected, Date dateSelected, String scheduleSelected, Enumeration<String> featuresSelected, int capacity, String comments) {
	}

	/**
	 * Retourne le nombre de salles disponibles avec les caractéristiques, la date, le créneau et la capacité choisie.
	 * @param capacity 
	 * @param featuresSelected 
	 * @param scheduleSelected 
	 * @param dateSelected 
	 */
	public int checkFreeRooms(Date dateSelected, String scheduleSelected, Enumeration<String> featuresSelected, int capacity) 
	{

		return 0;
	}

}
