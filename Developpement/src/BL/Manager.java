package BL;

import java.util.ArrayList;


public abstract class Manager {

	private ArrayList<Feature> allFeatures;
	private ArrayList<Schedule> allSchedules;
	private ArrayList<Booking> allBookings;
	private Booking selectedBooking;


	/**
	 * retourne une liste de toutes les caract�ristiques existantes.
	 */
	public abstract ArrayList<Feature> getFeatures() ;

	/**
	 * retourne une liste de tous les cr�neaux existants.
	 */
	public abstract ArrayList<Schedule> getSchedules() ;

	/**
	 * Retourne la liste de toutes les r�servations qui ne sont pas encore valid�es, c'est � dire pour lesquelles aucune salle n'est attribu�e.
	 */
	public abstract ArrayList<Booking> getAllUnvalidBookings() ;

	/**
	 * Ecoute les �v�nements sur le tableau, lors d'un clique sur celui-ci enregistre la r�servation s�lectionn� puis affiche toutes ses informations.
	 */
	public void selectBooking(int reference) {
		selectedBooking = allBookings.get(reference);
	}

	/**
	 * retourne sous la forme d'une structure compos�e de strings toutes les informations sur le teacher, c'est � dire nom, pr�nom, t�l�phone, mail et enseignement.
	 */
	public String getBookingTeacherInfos() {
		return selectedBooking.getTeacherInfos();
	}

	/**
	 * Retourne la date de la r�servation selectionn�e.
	 */
	public String getSelectedBookingDate() {
		return selectedBooking.getDate();
	}

	/**
	 * Retourne le cr�neau de la r�servation selectionn�e.
	 */
	public String getSelectedBookingSchedule() {
		return selectedBooking.getStringSchedule();
	}

	/**
	 * Retourne sous forme de liste de structure les dates et cr�neaux pour lesquelles il y aucune salle libre avec les param�tre de la r�servation selectionn�e.
	 */
	public abstract ArrayList<String> getWeekUnvalidSchedules() ;

	/**
	 * Remplace l'ancienne date de la reservation par la nouvelle date.
	 */
	public void setSelectedBookingDate(String date) {
		selectedBooking.setDate(date);
	}

	/**
	 * Remplace l'ancien cr�neau de la reservation par le nouveau cr�neau.
	 */
	public void setSelectedBookingSchedule(Schedule schedule) {
		selectedBooking.setSchedule(schedule);
	}

	/**
	 * Remplace les anciennes caract�ristiques de la reservation par les nouvelles.
	 */
	public void setSelectedBookingFeatures(ArrayList<Feature> features) {
		selectedBooking.setFeatures(features);
	}

	/**
	 * Sauvegarde la r�servation selectionn�e et lui associe une salle.
	 */
	public void saveSelectedBooking() {
		selectedBooking.save();
	}

	/**
	 * Supprime la r�servation selectionn�e.
	 */
	public abstract void deleteSelectedBooking() ;

}
