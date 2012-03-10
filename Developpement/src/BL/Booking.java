package BL;

import java.util.ArrayList;


/**
 * 																																																																																																																																																																																																										
 */
public abstract class Booking 
{
	protected String id;
	protected String room;
	protected Schedule schedule;
	protected Teaching teaching;
	protected String date;

	protected int capacity;
	protected String comments;

	protected ArrayList<Feature> features;

	/**
	 * Cr�e une nouvelle r�servation.
	 */
	public static Booking create() {
		return null;
	}


	/**
	 * Charge la r�servation qui � pour id reference.
	 * @throws Exception 
	 */
	public abstract void load(String reference) throws Exception ;

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
	 * Renvoie la salle de la r�servation.
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * Associe une salle � la r�servation.
	 */
	public void setRoom(String room) {
		this.room = room;
	}
	
	/**
	 * Retourne l'enseignant de la r�servation en chaine de caracteres.
	 */
	public String getTeacherInfos() {
		return teaching.getTeacherInfos();
	}

	/**
	 * Retourne le cr�neau de r�servation en chaine de caracteres.
	 */
	public String getStringSchedule() {
		return schedule.toString();
	}

	/**
	 * Sauvegarde la r�servation.
	 */
	public abstract boolean save() ;




}
