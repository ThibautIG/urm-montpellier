package Persist;
import java.sql.Connection;

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

Feature getFeatures() {
  }

  Schedule getSchedules() {
  }

  Booking getAllUnvalidBookings() {
  }

  void deleteSelectedBooking() {
  }

  /**
   * Retourne sous forme de liste de structure les dates et créneaux pour lesquelles il y des salles libre avec les paramètre de la réservation selectionnée.
   */
  list struct string getWeekValidSchedules() {
  }

}
