package Persist;
import BL.*;

import java.sql.*;


class PersistFactoryJDBC extends PersistFactory 
{
  /**
   * Objet qui contient la connection à la base de données.
   */
  private Connection dbConnection;
  private String driver= "sun.jdbc.odbc.JdbcOdbcDriver";
  private String url="jdbc:odbc:base_de_donnees";
  private String login="loginName";
  private String password="Password";
  
  PersistFactoryJDBC()
  {
	  // Charger le driver
	  try 
	  {
		  Class.forName(driver); //Or any other driver
	  }
	  catch(Exception x)
	  {
		  System.out.println("Unable to load the driver class!");
	  }
	  
	  // Créer la connection
	  try
	  {
		  this.dbConnection=DriverManager.getConnection(url,login,password);
	  }
	  catch(SQLException x)
	  {
		 	System.out.println("Couldn’t get connection!");
	  }
  }

  protected Teacher createTeacher() 
  {
	  return new TeacherJDBC(this.dbConnection);
  }

  protected Teaching createTeaching() 
  {
	  return new TeachingJDBC(this.dbConnection);
  }
  
  protected Booking createBooking() 
  {
	  return new BookingJDBC(this.dbConnection);
  }

  protected Feature createFeature()
  {
	  return new FeatureJDBC(this.dbConnection);
  }

  protected Schedule createSchedule() 
  {
	  return new ScheduleJDBC(this.dbConnection);
  }

  protected Manager createManager() 
  {
	  return new ManagerJDBC(this.dbConnection);
  }



}
