package Persist;
import java.sql.Connection;

import BL.Teaching;


class TeachingJDBC extends Teaching {
	
	Connection dbConnection;

	public TeachingJDBC(Connection dbConnection) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void load(String id) {

	}

}
