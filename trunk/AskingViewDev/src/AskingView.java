import javax.swing.*;


class AskingView extends JFrame
{
	// Donn�es r�colt�es
	//private TeacherFacade account;
	private String featuresSelected;
	private String scheduleSelected;
	private String dateSelected;
	private String teachingSelected;
	private int capacity;
	private String comments;
	
	// Fa�ade
	private TeacherFacade tf;
	
	// Panneaux
	private ChooseTypePanel p1; // Panneau 1 Choix du type de r�servation et le cas �ch�ant de l'enseignement
	private TimePanel p2; // Panneau 2 Choix de la date et du cr�neau
	private FeaturePanel p3;

	AskingView() 
	{
		  this.setTitle("Demande de r�servation");
		  
		  // Panneau 1 Choix du type de r�servation et le cas �ch�ant de l'enseignement
		  this.p1 = new ChooseTypePanel(this.tf);
		  this.add(p1);
		  
		  // Panneau 2 Choix de la date et du cr�neau
		  this.p2 = new TimePanel(this.tf);
		  this.add(this.p2);
	}

  /**
   * M�thode qui �coute les �v�nement sur les radios boutons de s�lection du type de demande.
   */
  void selectRequestType() 
  {
	  
  }

  /**
   * M�thode qui �coute le widget pour la s�lection d'un enseignement et sauvegarde l'enseignement choisi.
   */
  void selectTeaching() 
  {
	  
  }

  /**
   * �coute les �v�nements du calendrier et sauvegarde la date choisie.
   */
  void selectDate() 
  {
	  
  }

  /**
   * �coute les �v�nements sur la ComboBox de selection du cr�neau et sauvegarde le cr�neau choisi.
   */
  void selectSchedule() 
  {
	  
  }

  /**
   * Ajoute la caract�ristique s�lectionn�e dans la liste de gauche � la liste de droite. Sauvegarde cette caract�ristique.
   */
  void addFeature() 
  {
	  
  }

  /**
   * �coute la boite d'�ddition capacit� et sauvegarde la donn�e rentr�e.
   */
  void setCapacity() 
  {
	  
  }

  /**
   * �coute la zone d'�ddition et sauvegarde le contenu de celle-ci.
   */
  void setComments() 
  {
	  
  }

  /**
   * retourne le nombre de salles libres avec les param�tres de la r�servation.
   */
  int checkFreeRooms() 
  {
	  return 0;
  }

  /**
   * Valide la r�servation avec les param�tres choisis. Si un param�tre n'est pas s�lectionn� alors la validation renvoie une erreur.
   */
  void confirmBooking() 
  {
	  
  }

}
