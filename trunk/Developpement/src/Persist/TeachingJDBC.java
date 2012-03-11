package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BL.Teaching;


class TeachingJDBC extends Teaching {

	Connection dbConnection;

	public TeachingJDBC(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public void load(String reference) throws Exception 
	{
		String idField;
		
		String query = "select count(*) from ENSEIGNEMENT where ID_ENSEIGNEMENT = '" + reference + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);

		// v�rifier qu'il y a qu'un seul enseignement
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}

		// R�cup�rer les infos du cr�neau
		query = "select * from ENSEIGNEMENT where ID_ENSEIGNEMENT = '" + reference + "'";
		results = stmt.executeQuery(query);
		results.next();
		
		/** teacher??? **/
		
		this.id = results.getString(1);

		if (results.getString(4) == "") {
			this.type = "reunion";
		}
		else 
			this.group = results.getInt(4);
			
		this.hours = results.getInt(5);
		
		idField = results.getString(2);
		
		// R�cup�rer l'intitul� du cours
		query = "select COUNT(*) from COURS c, MATIERE m where c.ID_MATIERE = m.ID_MATIERE and c.ID_COURS = '" + idField + "'";
		results = stmt.executeQuery(query);
		results.next();
		if(results.getString(1) == "")
		{
			throw new SQLException(); 
		}
		
		query = "select m.LIBELLE_MATIERE from COURS c, MATIERE m where c.ID_MATIERE = m.ID_MATIERE and c.ID_COURS = '" + idField + "'";
		results = stmt.executeQuery(query);
		results.next();
		field = results.getString(1);
	}

}
