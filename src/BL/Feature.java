
abstract class Feature {
  private String id;

  private String name;

  /**
   * Chage la caractéristique correspondant à l'id donné en paramètre.
   */
  abstract  load() ;

  /**
   * Retourne l'id de la caractéristique.
   */
  String getId() {
  }

}
