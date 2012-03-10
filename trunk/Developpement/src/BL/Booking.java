package BL;

import java.util.ArrayList;


/**
 * 																																																																																																																																																																																																										
 */
public abstract class Booking 
{
	private String id;
	private int capacity;
	private String date;
	private String comments;
	private String idSalle;
	private Schedule schedule;
	private ArrayList<Feature> features;
	private Teaching teaching;

	/**
	 * Cr�e une nouvelle r�servation.
	 */
	public static Booking create() {
		return null;
	}

	/**
	 * Charge la r�servation qui � pour id reference.
	 */
	public abstract void load(String reference) ;

	/**
	 * Retourne le nombre de salles de disponibles pour les param�tres de cette r�servation.
	 */
	public abstract int checkFreeRooms() ;

	/**
	 * Retourne l'enseignement li� � cette r�servation.
	 */
	public Teaching getTeaching() {
		return teaching;
	}

	/**
	 * Retourne la date de r�servation.
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
	 * Retourne le cr�neau de r�servation.
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/**
	 * Remplace le cr�neau de r�servation.
	 */
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	/**
	 * Retourne la liste des caract�ristiques de la r�servation.
	 */
	public ArrayList<Feature> getFeatures() {
		return features;
	}

	/**
	 * Remplace la liste des caract�ristiques de la r�servation.
	 */
	public void setFeatures(ArrayList<Feature> features) {
		this.features = features;
	}

	/**
	 * Associe une salle � la r�servation.
	 */
	public abstract void setSalle() ;

	/**
	 * Sauvegarde la r�servation.
	 */
	public abstract boolean save() ;

	public String getTeacherInfos() {
		return teaching.getTeacherInfos();
	}

	public String getStringSchedule() {
		return schedule.toString();
	}

}
