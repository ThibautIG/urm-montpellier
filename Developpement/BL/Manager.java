package BL;

import java.util.ArrayList;


public abstract class Manager {

	private ArrayList<Feature> allFeatures;
	private ArrayList<Schedule> allSchedules;
	private ArrayList<Booking> allBookings;
	private Booking selectedBooking;


	/**
	 * retourne une liste de toutes les caractéristiques existantes.
	 */
	public abstract ArrayList<Feature> getFeatures() ;

	/**
	 * retourne une liste de tous les créneaux existants.
	 */
	public abstract ArrayList<Schedule> getSchedules() ;

	/**
	 * Retourne la liste de toutes les réservations qui ne sont pas encore validées, c'est à dire pour lesquelles aucune salle n'est attribuée.
	 */
	public abstract ArrayList<Booking> getAllUnvalidBookings() ;

	/**
	 * Ecoute les événements sur le tableau, lors d'un clique sur celui-ci enregistre la réservation sélectionné puis affiche toutes ses informations.
	 */
	public void selectBooking(int reference) {
		selectedBooking = allBookings.get(reference);
	}

	/**
	 * retourne sous la forme d'une structure composée de strings toutes les informations sur le teacher, c'est à dire nom, prénom, téléphone, mail et enseignement.
	 */
	public String getBookingTeacherInfos() {
		return selectedBooking.getTeacherInfos();
	}

	/**
	 * Retourne la date de la réservation selectionnée.
	 */
	public String getSelectedBookingDate() {
		return selectedBooking.getDate();
	}

	/**
	 * Retourne le créneau de la réservation selectionnée.
	 */
	public String getSelectedBookingSchedule() {
		return selectedBooking.getStringSchedule();
	}

	/**
	 * Retourne sous forme de liste de structure les dates et créneaux pour lesquelles il y aucune salle libre avec les paramètre de la réservation selectionnée.
	 */
	public abstract ArrayList<String> getWeekUnvalidSchedules() ;

	/**
	 * Remplace l'ancienne date de la reservation par la nouvelle date.
	 */
	public void setSelectedBookingDate(String date) {
		selectedBooking.setDate(date);
	}

	/**
	 * Remplace l'ancien créneau de la reservation par le nouveau créneau.
	 */
	public void setSelectedBookingSchedule(Schedule schedule) {
		selectedBooking.setSchedule(schedule);
	}

	/**
	 * Remplace les anciennes caractéristiques de la reservation par les nouvelles.
	 */
	public void setSelectedBookingFeatures(ArrayList<Feature> features) {
		selectedBooking.setFeatures(features);
	}

	/**
	 * Sauvegarde la réservation selectionnée et lui associe une salle.
	 */
	public void saveSelectedBooking() {
		selectedBooking.save();
	}

	/**
	 * Supprime la réservation selectionnée.
	 */
	public abstract void deleteSelectedBooking() ;

}
