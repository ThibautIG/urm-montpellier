package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import BL.TeacherFacade;

/**
 * 
 * @author URM Team
 * @description : classe permettant de générer l'interface graphique pour l'authentification
 */
public class LoginView extends JFrame implements ActionListener
{
	private TeacherFacade account;
	private MenuView menu;
	
    private JPanel pNorth, pSouth; //panneaux
    private JLabel lblLogin; //label Login
    private JLabel lblMdp; //label mot de passe
    private JTextField tfLogin; //champ texte login
    private JPasswordField tfMdp; //champ texte mot de passe
    private JButton bValid, bCancel; // boutons valider et annuler
    private MsgPopup erreur;

   /**
    * @param aucun
    * @description : constructeur de la fenêtre Login faisant appel à la métode initComponents();
    */
    public LoginView() 
    {
        initComponents();
    }

   /**
    * @return void
    * @description : méthode d'initialisation de la fenêtre graphique permettant l'authentification
    */
    private void initComponents() 
    {
    	//initialisation des widgets
    	this.setTitle("URM Authentification");
    	this.setSize(400,300); //On donne une taille à notre fenêtre
    	this.setResizable(false); //elle ne peut pas être redimensionnée
    	
		/** construction du panneau nord */
    	pNorth = new JPanel (new GridLayout(2,2)); //panneau nord composé de 2 Jlabel et de 2 champs
    	
    	lblLogin = new JLabel("Login :"); //label Login
    	tfLogin = new JTextField(); //champ texte pour renseigner l'identifiant
    	tfLogin.setPreferredSize(new Dimension (90, 20)); //redimensionnement du champ texte
    	tfLogin.setToolTipText("Entrez votre identifiant"); //indication à l'utilisateur

    	lblMdp = new JLabel("Mot de passe :"); //label mot de passe
    	tfMdp = new JPasswordField(); //champ texte mot de passe pour renseigner le mot de passe
    	tfMdp.setPreferredSize(new Dimension (90, 20)); //redimensionnement du champ texte
    	tfMdp.setToolTipText("Entrez votre mot de passe"); //indication à l'utilisateur
    	
    	/** ajout des widgets du panneau nord */
    	
    	pNorth.add(lblLogin);
    	pNorth.add(tfLogin);
    	pNorth.add(lblMdp);
    	pNorth.add(tfMdp);
    	
		/** construction du panneau sud */

    	pSouth = new JPanel (); //panneau sud contenant les boutons
    	
    	bValid = new JButton("Valider"); bValid.setActionCommand("valid"); bValid.addActionListener(this); //création et initialisation du bouton "valider"
    	bCancel = new JButton("Annuler"); bCancel.setActionCommand("cancel"); bCancel.addActionListener(this); //création et initialisation du bouton "annuler"
    	
    	/** ajout des widgets du panneau sud */
    	
    	pSouth.add(bValid);
    	pSouth.add(bCancel);
    	
    	/** ajout des panneaux à la fenêtre */
    	this.getContentPane().add(pNorth, BorderLayout.NORTH); //On ajoute un panneau au nord
    	this.getContentPane().add(pSouth, BorderLayout.SOUTH); //On ajoute un panneau au sud
    	
    	this.setLocationRelativeTo(null); //on place la fenêtre au centre de l'écran    
        this.setVisible(true); //la fenêtre est rendue visible
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //termine le programme lorsqu'on le ferme
        pack();
    }

	/**
	 * @param ActionEvent e : évenement provenant d'un clic sue un bouton
	 * @return : void
	 * @description : écoute les événements provenant d'un clic sur bouton - méthode issue de l'interface ActionListener
	 */
    public void actionPerformed(ActionEvent e) 
	{		
		if (e.getActionCommand().equals("valid")) //l'utilisateur clique sur valider
		{
			this.account = new TeacherFacade(); //on crée un nouvel objet compte identifiant un enseignant

				boolean connected = this.account.connect(this.tfLogin.getText(), new String(this.tfMdp.getPassword()));
				
				if (connected)
				{
					this.menu = new MenuView(account);
					this.setVisible(false);
				}
				
				else
				{
					System.out.println("L'utilisateur n'est pas connecté");
					erreur = new MsgPopup("Impossible de se connecter. Vérifiez vos identifiant et mot de passe.");
				}
				

		}
		else if (e.getActionCommand().equals("cancel")) 
		{
			System.exit(0);
		}
	}
	
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
    	new LoginView();
    }

}
