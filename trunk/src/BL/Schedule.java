
abstract class Schedule {
  private String id;

  private String endTime;

  private String startTime;

  /**
   * Charge le créneau avec l'id correspondant.
   */
  abstract  load() ;

  /**
   * Retourne l'id du créneau.
   */
  String getId() {
  }

}
