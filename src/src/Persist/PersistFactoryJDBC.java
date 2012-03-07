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
  private String url="jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ORA10";
  private String login="thibaut.rouquette";
  private String password="oracle";
  
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

  public Teacher createTeacher() 
  {
	  return new TeacherJDBC(this.dbConnection);
  }

  public Teaching createTeaching() 
  {
	  return new TeachingJDBC(this.dbConnection);
  }
  
  public Booking createBooking() 
  {
	  return new BookingJDBC(this.dbConnection);
  }

  public Feature createFeature()
  {
	  return new FeatureJDBC(this.dbConnection);
  }

  public Schedule createSchedule() 
  {
	  return new ScheduleJDBC(this.dbConnection);
  }

  public Manager createManager() 
  {
	  return new ManagerJDBC(this.dbConnection);
  }



}
