package BL;


public abstract class Teaching 
{
	protected String id;
	protected int hours;
	protected String group;
	protected String field;
	protected Teacher teacher;
	protected String type;

	/**
	 * Charge l'enseignement correspondant à l'id donné en paramètre.
	 * @throws Exception 
	 */
	public abstract void load(String id) throws Exception ;
	
	public void create(String id, int hours, String group, Teacher teacher, String field, String type)
	{
		this.id = id;
		this.hours = hours;
		this.group = group;
		this.field = field;
		this.teacher = teacher;
		this.type = type;
	}

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
	
	public String toString()
	{
		return this.type.substring(0, 5) + " " +this.field;
		
	}
}
