import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.xml.internal.ws.api.server.Container;


class AskingView extends JFrame implements ActionListener
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
	private FeaturePanel p3; // Panneau 3 Choix des caractéristiques
	private CommentsCapacityPanel p4; // Panneau 4 Choix de la capacitée et commentaires
	private FreeRoomPanel p5; // Panneau 5 Affichage du nombre de salles libres
	private JPanel p6; // Panneau 6 Boutons de validation et d'annulation
	
	// Boutons
	private JButton valid;
	private JButton cancel;

	AskingView() 
	{
		  super("Demande de réservation");
		  this.setSize(new Dimension(800, 600));
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  java.awt.Container cp = this.getContentPane();
		  
		  // Panneau 1 Choix du type de réservation et le cas échéant de l'enseignement
		  this.p1 = new ChooseTypePanel(this.tf);
		  cp.add(p1, BorderLayout.NORTH);
		  
		  // Panneau 2 Choix de la date et du créneau
		  this.p2 = new TimePanel(this.tf);
		  cp.add(this.p2);
		  
		  // Panneau 3 Choix des caractéristiques
		  this.p3 = new FeaturePanel(this.tf);
		  cp.add(this.p3);
		  
		  // Panneau 4 Choix de la capacitée et commentaires
		  this.p4 = new CommentsCapacityPanel(this.tf);
		  cp.add(this.p4);
		  
		  // Panneau 5 Affichage du nombre de salles libres
		  this.p5 = new FreeRoomPanel(this.tf);
		  cp.add(this.p5);
		  
		  // Boutons
		  this.p6 = new JPanel();
		  this.valid = new JButton("Valider");
		  this.cancel = new JButton("Annuler");
		  this.p6.add(this.valid);
		  this.p6.add(this.cancel);
		  cp.add(p6, BorderLayout.SOUTH);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
