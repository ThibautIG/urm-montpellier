
abstract class Feature {
  private String id;

  private String name;

  /**
   * Chage la caract�ristique correspondant � l'id donn� en param�tre.
   */
  abstract  load() ;

  /**
   * Retourne l'id de la caract�ristique.
   */
  String getId() {
  }

}
