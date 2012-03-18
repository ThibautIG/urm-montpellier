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

/**
 * Accès aux informations communes de la base de données.
 * @author URM Team
 */
class ManagerJDBC extends Manager 
{
	/**
	 * Connection vers la base de données.
	 */
	Connection dbConnection;

	/**
	 * Constructeur
	 * @param dbConnection
	 * 			Connection commune à la base de données.
	 */
	public ManagerJDBC(Connection dbConnection) 
	{
		this.dbConnection = dbConnection;
	}

	/**
	 * @see Manager#getFeatures()
	 * @throws SQLException 
	 * 			Problème d'accès à la base de données.
	 */
	public ArrayList<Feature> getFeatures() throws SQLException 
	{
		if(this.allFeatures == null)
		{
			this.allFeatures = new ArrayList<Feature>();
			
			String query = "select * from CARACTERISTIQUE";
			Statement stmt = dbConnection.createStatement();
			ResultSet results = stmt.executeQuery(query);
			
			while(results.next())
			{
				Feature ft = PersistFactory.getInstance().createFeature();
				ft.create(results.getString(1).trim(), results.getString(2).trim());
				this.allFeatures.add(ft);
			}
		}
		
		return this.allFeatures;
	}

	/**
	 * @see Manager#getSchedules()
	 * @throws SQLException 
	 * 			Problème d'accès à la base de données.
	 */
	public ArrayList<Schedule> getSchedules() throws SQLException
	{
		if(this.allSchedules == null)
		{
			this.allSchedules = new ArrayList<Schedule>();
			
			String query = "select * from crenaux";
			Statement stmt = dbConnection.createStatement();
			ResultSet results = stmt.executeQuery(query);
			
			while(results.next())
			{
				Schedule schedule = PersistFactory.getInstance().createSchedule();
				schedule.create(results.getString(1).trim(), results.getString(2).trim(), results.getString(3).trim());
				this.allSchedules.add(schedule);
			}
		}
		
		return this.allSchedules;
	}

	/**
	 * @see Manager#getAllUnvalidBookings()
	 */
	public ArrayList<Booking> getAllUnvalidBookings() 
	{
		return null;
	}

	/**
	 * @see Manager#deleteSelectedBooking()
	 */
	public void deleteSelectedBooking() 
	{
	}

	/**
	 * @see Manager#getWeekUnvalidSchedules()
	 * @return sous forme de liste de structure les dates et créneaux pour lesquelles il y des salles libre avec les paramètre de la réservation selectionnée.
	 */
	@Override
	public ArrayList<String> getWeekUnvalidSchedules() 
	{
		return null;
	}

}
