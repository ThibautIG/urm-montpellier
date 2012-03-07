package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String query = "select * from enseignant where nom = '" + pseudo + "' and mdp = '" + pwd + "'";
		System.out.println(query);
		
		Statement stmt = dbConnection.createStatement();
		
		ResultSet results = stmt.executeQuery(query);
		
	}

	Teaching getTeaching() 
	{
		return null;
	}

	public boolean isSuperUser()
	{
		return false;
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
