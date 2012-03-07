package BL;

public abstract class Feature {
  private String id;

  private String name;

  /**
   * Chage la caractéristique correspondant à l'id donné en paramètre.
   */
  public abstract void load(String id) ;

  /**
   * Retourne l'id de la caractéristique.
   */
  public String getId() {
		return id;
  }

}
