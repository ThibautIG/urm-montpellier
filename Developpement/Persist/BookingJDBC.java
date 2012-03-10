package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
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

		String query = "select * from Reservation where id = '" + reference + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		Schedule schedule = new ScheduleJDBC(dbConnection);
		Teaching teaching = new TeachingJDBC(dbConnection);
		schedule.load(results.getString(3));
		teaching.load(results.getString(4));
		
		this.id = results.getString(1);
		this.idSalle = results.getString(2);
		this.schedule = schedule;
		this.teaching = teaching;
		this.date = results.getString(5);

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

	@Override
	public void setSalle() {
		// TODO Auto-generated method stub

	}

}
