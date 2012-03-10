package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BL.Booking;
import BL.Feature;
import BL.Schedule;
import BL.Teaching;


class BookingJDBC extends Booking 
{

	Connection dbConnection;

	public BookingJDBC(Connection dbConnection) 
	{
		this.dbConnection = dbConnection;
	}

	public int checkFreeRooms() 
	{
		return 0;
	}

	public boolean save() 
	{
		return false;
	}


	public void load(String reference) throws Exception 
	{
		ArrayList<Feature> listFeatures = new ArrayList<Feature>();
		int idSalle;
		
		String query = "select count(*) from Reservation where id_reservation = '" + reference + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		// vérifier qu'il y a qu'une seule réservation
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}
		
		// Récupérer les infos de la réservation
		query = "select * from Reservation where id_reservation = '" + reference + "'";
		stmt = dbConnection.createStatement();
		results = stmt.executeQuery(query);
		results.next();
		
		Schedule schedule = new ScheduleJDBC(dbConnection);
		Teaching teaching = new TeachingJDBC(dbConnection);

		
		schedule.load(results.getString(3));
		teaching.load(results.getString(4));
		
		this.id = results.getString(1);
		this.schedule = schedule;
		this.teaching = teaching;
		this.date = results.getString(5);

		/** Salle **/
		idSalle = results.getInt(2);
		query = "select count(*) from SALLE where ID_SALLE = '" + idSalle + "'";
		stmt = dbConnection.createStatement();
		results = stmt.executeQuery(query);

		// vérifier qu'il y a qu'une seule salle
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}
		
		query = "select NUMERO_SALLE from SALLE where ID_SALLE = '" + idSalle + "'";
		stmt = dbConnection.createStatement();
		results = stmt.executeQuery(query);
		results.next();

		this.room = results.getString(1);

		/** Caractéristique **/
		query = "select * from RESERVATION_CARACTERISTIQUE where ID_RESERVATION = '" + this.id + "'";
		stmt = dbConnection.createStatement();
		results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Feature feature = new FeatureJDBC(dbConnection);
			feature.load(results.getString(1));
			listFeatures.add(feature);
		}

		this.features = listFeatures;
	}
}
