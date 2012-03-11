package BL;

import java.util.ArrayList;
import java.util.Date;


/**
 * 																																																																																																																																																																																																										
 */
public abstract class Booking 
{
	protected String id;
	
	protected Date date;
	protected Schedule schedule;
	protected ArrayList<Feature> features;
	protected int capacity;

	protected Teaching teaching;
	protected String comments;
	protected String room;

	/**
	 * Crée une nouvelle réservation.
	 */
	public static Booking create() 
	{
		return null;
	}


	/**
	 * Charge la réservation qui à pour id reference.
	 * @throws Exception 
	 */
	public abstract void load(String reference) throws Exception ;

	/**
	 * Retourne le nombre de salles de disponibles pour les paramètres de cette réservation.
	 */
	public abstract int checkFreeRooms() throws Exception;

	/**
	 * Retourne l'enseignement lié à cette réservation.
	 */
	public Teaching getTeaching() 
	{
		return teaching;
	}

	/**
	 * Retourne la date de réservation.
	 */
	public Date getDate() 
	{
		return date;
	}

	/**
	 * Remplace la date de reservation.
	 */
	public void setDate(Date date) 
	{
		this.date=date;
	}

	/**
	 * Retourne le créneau de réservation.
	 */
	public Schedule getSchedule() 
	{
		return schedule;
	}

	/**
	 * Remplace le créneau de réservation.
	 */
	public void setSchedule(Schedule schedule) 
	{
		this.schedule = schedule;
	}

	/**
	 * Retourne la liste des caractéristiques de la réservation.
	 */
	public ArrayList<Feature> getFeatures() 
	{
		return features;
	}

	/**
	 * Remplace la liste des caractéristiques de la réservation.
	 */
	public void setFeatures(ArrayList<Feature> features) 
	{
		this.features = features;
	}

	/**
	 * Renvoie la salle de la réservation.
	 */
	public String getRoom() 
	{
		return room;
	}

	/**
	 * Associe une salle à la réservation.
	 */
	public void setRoom(String room) 
	{
		this.room = room;
	}
	
	/**
	 * Retourne l'enseignant de la réservation en chaine de caracteres.
	 */
	public String getTeacherInfos() 
	{
		return teaching.getTeacherInfos();
	}

	/**
	 * Retourne le créneau de réservation en chaine de caracteres.
	 */
	public String getStringSchedule() 
	{
		return schedule.toString();
	}

	/**
	 * Sauvegarde la réservation.
	 */
	public abstract boolean save() throws Exception;


	public String getField() 
	{
		return teaching.getField();
	}
	
	public void setTeaching(Teaching t)
	{
		this.teaching = t;
	}

}
