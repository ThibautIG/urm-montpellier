package Persist;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
		this.id = results.getString(1);
		this.lastName = results.getString(2);
		this.firstName = results.getString(3);
		this.password = results.getString(4);
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

			String query1 = "select m.LIBELLE_MATIERE from COURS c, MATIERE m where c.ID_COURS='"+results.getString(2)+"' and c.ID_MATIERE=m.ID_MATIERE";
			Statement stmt1 = dbConnection.createStatement();
			ResultSet results1 = stmt1.executeQuery(query1);
			results1.next();

			String query2 = "select tc.LIBELLE_TYPE_DE_COURS from TYPECOURS tc, COURS c where c.ID_COURS='"+results.getString(2)+"' and c.ID_TYPE_DE_COURS=tc.ID_TYPE_DE_COURS";
			Statement stmt2 = dbConnection.createStatement();
			ResultSet results2 = stmt2.executeQuery(query2);
			results2.next();

			tc.create(results.getString(1), results.getInt(5), results.getString(4), this, results1.getString(1), results2.getString(1));
			scs.add(tc);
		}

		return scs;
	}


	public ArrayList<Booking> getValidBooking(int week) throws Exception 
	{
		ArrayList<Booking> listBookings = new ArrayList<Booking>();
		Calendar cal = new GregorianCalendar();
		String debut = new String();
		String fin = new String();

		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(7);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		debut += (cal.get(Calendar.DAY_OF_MONTH) < 10)?"0" + cal.get(Calendar.DAY_OF_MONTH):cal.get(Calendar.DAY_OF_MONTH);
		debut += '-';
		debut += (cal.get(Calendar.MONTH) < 9)?"0" + (cal.get(Calendar.MONTH) + 1):cal.get(Calendar.MONTH) + 1;
		debut += '-';
		debut += cal.get(Calendar.YEAR);

		cal.add(Calendar.DAY_OF_WEEK, 6);
		fin += (cal.get(Calendar.DAY_OF_MONTH) < 10)?"0" + cal.get(Calendar.DAY_OF_MONTH):cal.get(Calendar.DAY_OF_MONTH);
		fin += '-';
		fin += (cal.get(Calendar.MONTH) < 9)?"0" + (cal.get(Calendar.MONTH) + 1):cal.get(Calendar.MONTH) + 1;
		fin += '-';
		fin += cal.get(Calendar.YEAR);
		

		String query = "select res.ID_RESERVATION from RESERVATION res, ENSEIGNEMENT ens where ID_SALLE is not null and res.id_enseignement = ens.id_enseignement AND ens.id_enseignant = '" 
				+ this.id + "' and DATE_RESERVATION >= '"+debut+"' AND DATE_RESERVATION <= '"+fin+"'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		while(results.next())
		{
			Booking booking = new BookingJDBC(dbConnection);
			booking.load(results.getString(1));
			listBookings.add(booking);
		}

		return listBookings;
	}

}
