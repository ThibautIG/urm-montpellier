package Persist;
import java.sql.Connection;
import java.util.ArrayList;

import BL.Booking;
import BL.Feature;
import BL.Manager;
import BL.Schedule;


class ManagerJDBC extends Manager {
	public ManagerJDBC() {
	}

	public ManagerJDBC(Connection dbConnection) {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Feature> getFeatures() {
		return null;
	}

	public ArrayList<Schedule> getSchedules() {
		return null;
	}

	public ArrayList<Booking> getAllUnvalidBookings() {
		return null;
	}

	public void deleteSelectedBooking() {
	}

	/**
	 * Retourne sous forme de liste de structure les dates et créneaux pour lesquelles il y des salles libre avec les paramètre de la réservation selectionnée.
	 */
	ArrayList<String> getWeekValidSchedules() {
		return null;
	}

	@Override
	public ArrayList<String> getWeekUnvalidSchedules() {
		// TODO Auto-generated method stub
		return null;
	}

}
