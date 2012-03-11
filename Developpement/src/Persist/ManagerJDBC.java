package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BL.Booking;
import BL.Feature;
import BL.Manager;
import BL.PersistFactory;
import BL.Schedule;


class ManagerJDBC extends Manager 
{

	Connection dbConnection;

	public ManagerJDBC(Connection dbConnection) 
	{
		this.dbConnection = dbConnection;
	}

	public ArrayList<Feature> getFeatures() throws SQLException 
	{
		ArrayList<Feature> alf = new ArrayList<Feature>();
		
		String query = "select * from CARACTERISTIQUE";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Feature ft = PersistFactory.getInstance().createFeature();
			ft.create(results.getString(1), results.getString(2));
			alf.add(ft);
		}
		
		return alf;
	}

	public ArrayList<Schedule> getSchedules() throws SQLException
	{
		ArrayList<Schedule> scs = new ArrayList<Schedule>();
		
		String query = "select * from crenaux";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Schedule schedule = PersistFactory.getInstance().createSchedule();
			schedule.create(results.getString(1), results.getString(2), results.getString(3));
			scs.add(schedule);
		}
		
		return scs;
	}

	public ArrayList<Booking> getAllUnvalidBookings() {
		return null;
	}

	public void deleteSelectedBooking() {
	}

	/**
	 * Retourne sous forme de liste de structure les dates et cr�neaux pour lesquelles il y des salles libre avec les param�tre de la r�servation selectionn�e.
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
