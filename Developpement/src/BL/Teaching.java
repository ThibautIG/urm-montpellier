package BL;


public abstract class Teaching {
	private String id;

	private int hours;

	private String group;

	private String type;

	private String field;

	private Teacher teacher;

	/**
	 * Charge l'enseignement correspondant � l'id donn� en param�tre.
	 */
	public abstract void load() ;

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
}
