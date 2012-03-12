package Persist;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BL.Booking;
import BL.PersistFactory;
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

		// vérifier qu'il y a qu'un seul enseignant
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}

		// Récupérer les infos de l'enseignant
		query = "select * from enseignant where nom = '" + pseudo + "' and mdp = '" + pwd + "'";
		results = stmt.executeQuery(query);

		results.next();
		this.id = results.getString(1).trim();
		this.lastName = results.getString(2).trim();
		this.firstName = results.getString(3).trim();
		this.password = results.getString(4).trim();
		this.superUser = results.getBoolean(5);
	}


	public ArrayList<Teaching> getTeachings()  throws SQLException
	{
		ArrayList<Teaching> scs = new ArrayList<Teaching>();
		
		String query = "select * from ENSEIGNEMENT e where e.ID_ENSEIGNANT='"+this.id+"'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Teaching tc = PersistFactory.getInstance().createTeaching();
			
			String query1 = "select m.LIBELLE_MATIERE from COURS c, MATIERE m where c.ID_COURS='"+results.getString(2).trim()+"' and c.ID_MATIERE=m.ID_MATIERE";
			Statement stmt1 = dbConnection.createStatement();
			ResultSet results1 = stmt1.executeQuery(query1);
			results1.next();
			
			String query2 = "select tc.LIBELLE_TYPE_DE_COURS from TYPECOURS tc, COURS c where c.ID_COURS='"+results.getString(2).trim()+"' and c.ID_TYPE_DE_COURS=tc.ID_TYPE_DE_COURS";
			Statement stmt2 = dbConnection.createStatement();
			ResultSet results2 = stmt2.executeQuery(query2);
			results2.next();
			
			tc.create(results.getString(1).trim(), results.getInt(5), results.getString(4).trim(), this, results1.getString(1).trim(), results2.getString(1).trim());
			scs.add(tc);
		}
		
		return scs;
	}


	public ArrayList<Booking> getValidBooking() throws Exception 
	{
		ArrayList<Booking> listBookings = new ArrayList<Booking>();

		String query = "select res.ID_RESERVATION from RESERVATION res, ENSEIGNEMENT ens where res.id_enseignement = ens.id_enseignement AND ens.id_enseignant = '" 
				+ this.id + "'";

		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);

		while(results.next())
		{
			Booking booking = new BookingJDBC(dbConnection);
			booking.load(results.getString(1).trim());
			listBookings.add(booking);
		}

		return listBookings;
	}

}
