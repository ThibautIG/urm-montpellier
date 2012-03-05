package BL;


abstract class Teaching {
  private String id;

  private int hours;

  private String group;

  private String type;

  private String field;

  /**
   * Charge l'enseignement correspondant à l'id donné en paramètre.
   */
  abstract  load() ;

  /**
   * Retourne l'enseignant qui enseigne cet enseignement.
   */
  Teacher getTeacher() {
  }

}
