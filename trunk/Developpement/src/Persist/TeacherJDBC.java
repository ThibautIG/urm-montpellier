package Persist;
import java.sql.*;
import java.util.ArrayList;

import BL.Booking;
import BL.Teacher;
import BL.Teaching;


class TeacherJDBC extends Teacher 
{
	Connection dbConnection;
	
	public TeacherJDBC(Connection dbConnection) 
	{
		this.dbConnection = dbConnection;
	}

	public void load(String pseudo, String pwd) throws SQLException
	{
		String query = "select count(*) from enseignant where nom = '" + pseudo + "' and mdp = '" + pwd + "'";
		
		Statement stmt = dbConnection.createStatement();
		
		ResultSet results = stmt.executeQuery(query);
		
		// vérifier qu'il y a qu'un seul compte
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}
		
		// Récupérer les infos de l'enseignant
		query = "select * from enseignant where nom = '" + pseudo + "' and mdp = '" + pwd + "'";
		results = stmt.executeQuery(query);
		
		results.next();
		this.id = results.getString(1);
		this.lastName = results.getString(2);
		this.firstName = results.getString(3);
		this.password = results.getString(4);
		this.superUser = results.getBoolean(5);
	}

	Teaching getTeaching() 
	{
		return null;
	}

	/**
	 * Type de retour à modifier
	 */
	public Booking getReservationsValidees() 
	{
		return null;
	}

	public ArrayList<Teaching> getTeachings() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<Booking> getValidBooking() {
		// TODO Auto-generated method stub
		return null;
	}

}
