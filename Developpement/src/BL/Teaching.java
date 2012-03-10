package BL;


public abstract class Teaching 
{
	protected String id;
	protected int hours;
	protected int group;
	protected String field;


	protected Teacher teacher;
	protected String type;

	/**
	 * Charge l'enseignement correspondant à l'id donné en paramètre.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;

	/**
	 * Retourne l'enseignant qui enseigne cet enseignement.
	 */
	public Teacher getTeacher() {
		return teacher;
	}

	public String getTeacherInfos() {
		return teacher.toString();
	}

	public String getId() {
		return id;
	}	

	public String getField() {
		return field;
	}
}
