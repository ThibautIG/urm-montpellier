package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BL.Teacher;
import BL.Teaching;


class TeachingJDBC extends Teaching {

	Connection dbConnection;

	public TeachingJDBC(Connection dbConnection) {
		// TODO Auto-generated constructor stub
	}

	public void load(String id) throws Exception {
		String query = "select count(*) from ENSEIGNEMENT where id = '" + id + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);

		// vérifier qu'il y a qu'un seul enseignement
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}

		// Récupérer les infos du créneau
		query = "select * from ENSEIGNEMENT where id = '" + id + "'";
		results = stmt.executeQuery(query);

		Teacher teacher = new TeacherJDBC(dbConnection);
		teacher.load(teacher.getId(), teacher.getPassword());
		
		this.id = results.getString(1);
		this.field = results.getString(2);
		this.teacher = teacher;
		if (results.getString(4) == null) {
			this.type = "reunion";
		}
		else 
			this.group = results.getInt(4);
			
		this.hours = results.getInt(5);

	}

}
