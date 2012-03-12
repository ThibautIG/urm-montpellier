package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

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

	@SuppressWarnings("deprecation")
	public int checkFreeRooms() throws SQLException 
	{
		String query = "select count(*) from SALLE s where ";
		
		for(int i=0; i<this.features.size(); i++)
		{
			query += ""+this.features.get(i).getId()+" IN (select ID_CARACTERISTIQUE from CARACTERISTIQUE_SALLE cs where s.ID_SALLE = cs.ID_SALLE) and ";
		}
		
		java.sql.Date d = new java.sql.Date(this.date.getTime());
		int m = d.getMonth()+1;
		String ms = ""+m;
		if(m<10)
		{
			ms = "0"+m;
		}
		int da = d.getDate();
		String das = ""+da;
		if(da<10)
		{
			das = "0"+da;
		}
		String dat = das+"-"+ms+"-"+(d.getYear()+1900);
		
		query += "(select count(*) from RESERVATION r where r.ID_SALLE=s.ID_SALLE and r.ID_CRENEAU="+this.schedule.getId()+" and r.DATE_RESERVATION='"+dat+"')=0";
		System.out.println(query);
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		results.next();
		
		return results.getInt(1);
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
		query = "select * from Reservation where ID_SALLE is not null and id_reservation = '" + reference + "'";
		stmt = dbConnection.createStatement();
		results = stmt.executeQuery(query);
		results.next();
		
		Schedule schedule = new ScheduleJDBC(dbConnection);
		Teaching teaching = new TeachingJDBC(dbConnection);

		
		schedule.load(results.getString(3).trim());
		teaching.load(results.getString(4).trim());
		
		this.id = results.getString(1).trim();
		this.schedule = schedule;
		this.teaching = teaching;
		this.date = results.getDate(5);
		
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
			feature.load(results.getString(1).trim());
			listFeatures.add(feature);
		}

		this.features = listFeatures;
	}
	
	@SuppressWarnings("deprecation")
	public boolean save() throws SQLException 
	{
		if(this.schedule!=null && this.teaching!=null)
		{
			String query1 = "select count(*) from reservation";
			Statement stmt1 = dbConnection.createStatement();
			ResultSet results1 = stmt1.executeQuery(query1);
			results1.next();
			
			java.sql.Date d = new java.sql.Date(this.date.getTime());
			int m = d.getMonth()+1;
			String ms = ""+m;
			if(m<10)
			{
				ms = "0"+m;
			}
			int da = d.getDate();
			String das = ""+da;
			if(da<10)
			{
				das = "0"+da;
			}
			String dat = das+"-"+ms+"-"+(d.getYear()+1900);
			
			String query = "insert into reservation values("+(results1.getInt(1)+1)+",null,"+this.schedule.getId()+","+this.teaching.getId()+",'"+dat+"')";
			Statement stmt = dbConnection.createStatement();
			@SuppressWarnings("unused")
			ResultSet results = stmt.executeQuery(query);
			return true;
		}
		else 
		{
			return false;
		}	
	}
}
