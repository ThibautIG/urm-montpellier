package BL;

import java.util.ArrayList;


public abstract class Teacher 
{
	protected String id;
	protected String firstName;
	protected String lastName;
	protected String password;
	protected String phone;
	protected String mail;
	protected boolean superUser;
	protected ArrayList<Teaching> myTeachings;


	/**
	 * Charge l'enseignant qui a l'id donné en paramètre.
	 * @param pwd 
	 * @throws Exception 
	 */
	public abstract void load(String id, String pwd) throws Exception;

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * Retourne la liste des enseignements de cet enseignant.
	 */
	public abstract ArrayList<Teaching> getTeachings() throws Exception;

	/**
	 * Retourne vrai si l'enseignant est le gestionnaire, faux sinon.
	 */
	public boolean isSuperUser() 
	{
		return this.superUser;
	}

	/**
	 * Retourne la liste des réservations qui ont été faites par l'utilisateur et qui ont été validées (Qui ont reçu une salle). 
	 * @throws Exception 
	 */
	public abstract ArrayList<Booking> getValidBooking() throws Exception;

	public String toString() {
		String result = "null";
		result = id+" "+firstName+" "+lastName+" "+phone+" "+mail+" "+superUser;
		return result;
	}

}
