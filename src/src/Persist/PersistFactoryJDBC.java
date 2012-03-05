package Persist;
import BL.*;
import java.sql.*;


class PersistFactoryJDBC extends PersistFactory 
{
  /**
   * Objet qui contient la connection � la base de donn�es.
   */
  private JDBC connect;
  
  PersistFactoryJDBC()
  {
	  // Charger le driver
	  try 
	  {
		  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); //Or any other driver
	  }
	  catch(Exception x)
	  {
		  System.out.println("Unable to load the driver class!");
	  }
	  
	  // Cr�er la connection
	  try
	  {
		  Connection dbConnection=DriverManager.getConnection(url,"loginName","Password");
	  }
	  catch( SQLException x )
	  {
		 	System.out.println("Couldn�t get connection!");
	  }
  }

  BookingJDBC createBooking() 
  {
	  
  }

  FeatureJDBC createFeature()
  {
	  
  }

  ScheduleJDBC createSchedule() 
  {
	  
  }

  ManagerJDBC createManager() 
  {
	  
  }

  TeacherJDBC createTeacher() 
  {
	  
  }

  TeachingJDBC createTeaching() 
  {
	  
  }

}
