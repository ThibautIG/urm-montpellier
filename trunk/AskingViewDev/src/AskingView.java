import javax.swing.*;


class AskingView extends JFrame
{
	// Données récoltées
	//private TeacherFacade account;
	private String featuresSelected;
	private String scheduleSelected;
	private String dateSelected;
	private String teachingSelected;
	private int capacity;
	private String comments;
	
	// Façade
	private TeacherFacade tf;
	
	// Panneaux
	private ChooseTypePanel p1; // Panneau 1 Choix du type de réservation et le cas échéant de l'enseignement
	private TimePanel p2; // Panneau 2 Choix de la date et du créneau
	private FeaturePanel p3;

	AskingView() 
	{
		  this.setTitle("Demande de réservation");
		  
		  // Panneau 1 Choix du type de réservation et le cas échéant de l'enseignement
		  this.p1 = new ChooseTypePanel(this.tf);
		  this.add(p1);
		  
		  // Panneau 2 Choix de la date et du créneau
		  this.p2 = new TimePanel(this.tf);
		  this.add(this.p2);
	}

  /**
   * Méthode qui écoute les événement sur les radios boutons de sélection du type de demande.
   */
  void selectRequestType() 
  {
	  
  }

  /**
   * Méthode qui écoute le widget pour la sélection d'un enseignement et sauvegarde l'enseignement choisi.
   */
  void selectTeaching() 
  {
	  
  }

  /**
   * écoute les événements du calendrier et sauvegarde la date choisie.
   */
  void selectDate() 
  {
	  
  }

  /**
   * écoute les événements sur la ComboBox de selection du créneau et sauvegarde le créneau choisi.
   */
  void selectSchedule() 
  {
	  
  }

  /**
   * Ajoute la caractéristique sélectionnée dans la liste de gauche à la liste de droite. Sauvegarde cette caractéristique.
   */
  void addFeature() 
  {
	  
  }

  /**
   * écoute la boite d'éddition capacité et sauvegarde la donnée rentrée.
   */
  void setCapacity() 
  {
	  
  }

  /**
   * écoute la zone d'éddition et sauvegarde le contenu de celle-ci.
   */
  void setComments() 
  {
	  
  }

  /**
   * retourne le nombre de salles libres avec les paramètres de la réservation.
   */
  int checkFreeRooms() 
  {
	  return 0;
  }

  /**
   * Valide la réservation avec les paramètres choisis. Si un paramètre n'est pas sélectionné alors la validation renvoie une erreur.
   */
  void confirmBooking() 
  {
	  
  }

}
