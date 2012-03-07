package BL;

public abstract class Feature {
  private String id;

  private String name;

  /**
   * Chage la caract�ristique correspondant � l'id donn� en param�tre.
   */
  public abstract void load(String id) ;

  /**
   * Retourne l'id de la caract�ristique.
   */
  public String getId() {
		return id;
  }

}
