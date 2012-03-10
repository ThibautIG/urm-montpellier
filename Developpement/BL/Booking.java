package BL;

import java.util.ArrayList;


/**
 * 																																																																																																																																																																																																										
 */
public abstract class Booking 
{
	protected String id;
	protected String idSalle;
	protected Schedule schedule;
	protected Teaching teaching;
	protected String date;

	protected int capacity;
	protected String comments;
	
	protected ArrayList<Feature> features;

	/**
	 * Crée une nouvelle réservation.
	 */
	public static Booking create() {
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
	public abstract int checkFreeRooms() ;

	/**
	 * Retourne l'enseignement lié à cette réservation.
	 */
	public Teaching getTeaching() {
		return teaching;
	}

	/**
	 * Retourne la date de réservation.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Remplace la date de reservation.
	 */
	public void setDate(String date) {
		this.date=date;
	}

	/**
	 * Retourne le créneau de réservation.
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/**
	 * Remplace le créneau de réservation.
	 */
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	/**
	 * Retourne la liste des caractéristiques de la réservation.
	 */
	public ArrayList<Feature> getFeatures() {
		return features;
	}

	/**
	 * Remplace la liste des caractéristiques de la réservation.
	 */
	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}

	/**
	 * Associe une salle à la réservation.
	 */
	public abstract void setSalle() ;

	/**
	 * Sauvegarde la réservation.
	 */
	public abstract boolean save() ;

	public String getTeacherInfos() {
		return teaching.getTeacherInfos();
	}

	public String getStringSchedule() {
		return schedule.toString();
	}

}
