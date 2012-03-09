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


@SuppressWarnings("serial")
class MenuView extends JFrame implements ActionListener
{
	private ConsulterView consulting;
	private AskingView Asking;
	private HandlingView Handling;
	private JPanel p;
	private JButton consult, ask, handle;
	private TeacherFacade user;
	
	/**
	 * Constructeur
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

		//initialisation des widgets
    	this.setTitle("URM Menu");
    	this.setSize(300,110); //On donne une taille à notre fenêtre
    	this.setResizable(false);
    	
    	// liste des boutons
    	consult = new JButton("Consulter planning"); consult.setPreferredSize(new Dimension (250,30)); consult.setActionCommand("consult"); consult.addActionListener(this);
    	ask = new JButton("Demande de réservation"); ask.setPreferredSize(new Dimension (250,30)); ask.setActionCommand("ask"); ask.addActionListener(this);
    	
    	
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



	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("consult"))
		{
			System.out.println("consulter");
		}
		else if (e.getActionCommand().equals("ask"))
		{
			System.out.println("demande");
		}
		else if (e.getActionCommand().equals("handle"))
		{
			System.out.println("traitement");
		}
	}
	
	/**
	 * Ecoute les actions sur le bouton.
	 */
	//selectBouton() {
	//}



}
