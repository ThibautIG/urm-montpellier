package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BL.Schedule;


class ScheduleJDBC extends Schedule {

	Connection dbConnection;

	public ScheduleJDBC(Connection dbConnection) 
	{
		this.dbConnection = dbConnection;
	}

	public void load(String id) throws Exception 
	{
		String query = "select count(*) from Crenaux where id = '" + id + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		
		// vérifier qu'il y a qu'un seul créneau
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}

		// Récupérer les infos du créneau
		query = "select * from Crenaux where id = '" + id + "'";
		results = stmt.executeQuery(query);
		
		this.id = results.getString(1);
		this.startTime = results.getString(2);
		this.endTime = results.getString(3);
	}

	public String getId() 
	{
		return null;
	}

}
