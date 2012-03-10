import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
class AskingView extends JFrame implements ActionListener
{
	// Donn�es r�colt�es
	private String featuresSelected;
	private int capacity;
	private String comments;
	
	// Fa�ade
	private TeacherFacade account;
	
	// Panneaux
	private ChooseTypePanel p1; // Panneau 1 Choix du type de r�servation et le cas �ch�ant de l'enseignement
	private TimePanel p2; // Panneau 2 Choix de la date et du cr�neau
	private FeaturePanel p3; // Panneau 3 Choix des caract�ristiques
	private CommentsCapacityPanel p4; // Panneau 4 Choix de la capacit�e et commentaires
	private FreeRoomPanel p5; // Panneau 5 Affichage du nombre de salles libres
	private JPanel p6; // Panneau 6 Boutons de validation et d'annulation
	
	// Boutons
	private JButton valid;
	private JButton cancel;

	AskingView() 
	{
		  super("Demande de r�servation");
		  this.setSize(new Dimension(800, 600));
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  
		  java.awt.Container cp = this.getContentPane();
		  
		  cp.setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
		  
		  // Panneau 1 Choix du type de r�servation et le cas �ch�ant de l'enseignement
		  this.p1 = new ChooseTypePanel(this.account);
		  //cp.add(p1);
		  
		  // Panneau 2 Choix de la date et du cr�neau
		  this.p2 = new TimePanel(this.account);
		  //cp.add(this.p2);
		  
		  // Panneau 3 Choix des caract�ristiques
		  this.p3 = new FeaturePanel(this.account);
		  //cp.add(this.p3);
		  
		  // Panneau 4 Choix de la capacit�e et commentaires
		  this.p4 = new CommentsCapacityPanel(this.account);
		  //cp.add(this.p4);
		  
		  // Panneau 5 Affichage du nombre de salles libres
		  this.p5 = new FreeRoomPanel(this.account);
		  //cp.add(this.p5);
		  
		  // Boutons
		  this.p6 = new JPanel();
		  this.valid = new JButton("Valider");
		  this.cancel = new JButton("Annuler");
		  this.p6.add(this.valid);
		  this.p6.add(this.cancel);
		  //cp.add(p6);
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}

}
