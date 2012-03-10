package Persist;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BL.Feature;


class FeatureJDBC extends Feature {

	Connection dbConnection;


	public FeatureJDBC(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}


	public String getId() {
		return null;
	}

	public void load(String id) throws Exception {
		String query = "select count(*) from CARACTERISTIQUE where id = '" + id + "'";
		Statement stmt = dbConnection.createStatement();
		ResultSet results = stmt.executeQuery(query);

		// v�rifier qu'il y a qu'un seul compte
		results.next();
		if(results.getInt(1) != 1)
		{
			throw new SQLException(); 
		}

		// R�cup�rer les infos du cr�neau
		query = "select * from CARACTERISTIQUE where id = '" + id + "'";
		results = stmt.executeQuery(query);

		this.id = results.getString(1);
		this.name = results.getString(2);
	}

}
