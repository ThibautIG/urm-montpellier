
abstract class Schedule {
  private String id;

  private String endTime;

  private String startTime;

  /**
   * Charge le cr�neau avec l'id correspondant.
   */
  abstract  load() ;

  /**
   * Retourne l'id du cr�neau.
   */
  String getId() {
  }

}
