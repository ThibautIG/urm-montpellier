package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import BL.TeacherFacade;


/**
 * 
 * @author URM Team
 * @description : classe permettant de générer l'interface graphique pour le menu utilisateur
 */

class MenuView extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ConsulterView consulting;
	private AskingView Asking;
	private HandlingView Handling;
	private JPanel p;
	private JButton consult, ask, handle;
	private TeacherFacade user;
	
	 /**
     * Constructeur
     * @param : c : objet de type TeacherFacade faisant référence au compte d'un enseignant
     */

	public  MenuView(TeacherFacade c) 
	{
		this.user = c;
		initComponents();
	}
	
	public  MenuView() //constructeur à supprimer
	{
		initComponents();
	}

	
	private void initComponents() 
	{

		/** initialisation de la fenêtre et des widgets */
    	this.setTitle("URM Menu");
    	this.setSize(300,110); //On ajuste la taille de la fenêtre
    	this.setResizable(false);
    	
    	// liste des boutons
    	consult = new JButton("Consulter planning"); consult.setPreferredSize(new Dimension (250,30)); consult.setActionCommand("consult"); consult.addActionListener(this);
    	ask = new JButton("Demande de réservation"); 
    	ask.setPreferredSize(new Dimension (250,30)); 
    	ask.setActionCommand("ask"); 
    	ask.addActionListener(this);
    	
    	
    	/** Initialisation du panneau */
    	p = new JPanel (new FlowLayout());
    	
    	p.add(consult);
    	p.add(ask);
    	if(this.user.isSuperUser())
    	{
    		this.setSize(300,150); //On donne une taille à notre fenêtre
			handle = new JButton("Traitement des demandes"); handle.setPreferredSize(new Dimension (250,30)); handle.setActionCommand("handle"); handle.addActionListener(this);
        	p.add(handle);
    	}
    	
    	this.add(p);
    	
    	this.setLocationRelativeTo(null);     
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	
	}


	 /**
     * @param ActionEvent e : évenement provenant d'un clic sue un bouton
     * @return : void
     * @description : écoute les événements provenant d'un clic sur bouton - méthode issue de l'interface ActionListener
     */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("consult"))
		{
			ConsulterView cv = new ConsulterView(this.user);
		}
		else if (e.getActionCommand().equals("ask"))
		{
			AskingView av = new AskingView(this.user);
		}
		else if (e.getActionCommand().equals("handle"))
		{
			System.out.println("traitement");
		}
	}
	
}
