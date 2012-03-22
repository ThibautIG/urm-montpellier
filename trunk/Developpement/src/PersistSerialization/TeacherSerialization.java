package PersistSerialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import BL.Booking;
import BL.Teacher;

public class TeacherSerialization extends Teacher implements Serializable
{

	private static final long serialVersionUID = -3433592847741500802L;

	@Override
	public void load(String nom, String pwd) throws Exception 
	{
		FileInputStream fichier = new FileInputStream("teacher.ser");
		ObjectInputStream ois = new ObjectInputStream(fichier);
		TeacherSerialization t = (TeacherSerialization) ois.readObject();

	}

	@Override
	public ArrayList<Booking> getValidBooking(int week) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
