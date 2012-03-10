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
 * @description : classe permettant de g�n�rer l'interface graphique pour l'authentification
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
    * @description : constructeur de la fen�tre Login faisant appel � la m�tode initComponents();
    */
    public LoginView() 
    {
        initComponents();
    }

   /**
    * @return void
    * @description : m�thode d'initialisation de la fen�tre graphique permettant l'authentification
    */
    private void initComponents() 
    {
    	//initialisation des widgets
    	this.setTitle("URM Authentification");
    	this.setSize(400,300); //On donne une taille � notre fen�tre
    	this.setResizable(false); //elle ne peut pas �tre redimensionn�e
    	
		/** construction du panneau nord */
    	pNorth = new JPanel (new GridLayout(2,2)); //panneau nord compos� de 2 Jlabel et de 2 champs
    	
    	lblLogin = new JLabel("Login :"); //label Login
    	tfLogin = new JTextField(); //champ texte pour renseigner l'identifiant
    	tfLogin.setPreferredSize(new Dimension (90, 20)); //redimensionnement du champ texte
    	tfLogin.setToolTipText("Entrez votre identifiant"); //indication � l'utilisateur

    	lblMdp = new JLabel("Mot de passe :"); //label mot de passe
    	tfMdp = new JPasswordField(); //champ texte mot de passe pour renseigner le mot de passe
    	tfMdp.setPreferredSize(new Dimension (90, 20)); //redimensionnement du champ texte
    	tfMdp.setToolTipText("Entrez votre mot de passe"); //indication � l'utilisateur
    	
    	/** ajout des widgets du panneau nord */
    	
    	pNorth.add(lblLogin);
    	pNorth.add(tfLogin);
    	pNorth.add(lblMdp);
    	pNorth.add(tfMdp);
    	
		/** construction du panneau sud */

    	pSouth = new JPanel (); //panneau sud contenant les boutons
    	
    	bValid = new JButton("Valider"); bValid.setActionCommand("valid"); bValid.addActionListener(this); //cr�ation et initialisation du bouton "valider"
    	bCancel = new JButton("Annuler"); bCancel.setActionCommand("cancel"); bCancel.addActionListener(this); //cr�ation et initialisation du bouton "annuler"
    	
    	/** ajout des widgets du panneau sud */
    	
    	pSouth.add(bValid);
    	pSouth.add(bCancel);
    	
    	/** ajout des panneaux � la fen�tre */
    	this.getContentPane().add(pNorth, BorderLayout.NORTH); //On ajoute un panneau au nord
    	this.getContentPane().add(pSouth, BorderLayout.SOUTH); //On ajoute un panneau au sud
    	
    	this.setLocationRelativeTo(null); //on place la fen�tre au centre de l'�cran    
        this.setVisible(true); //la fen�tre est rendue visible
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //termine le programme lorsqu'on le ferme
        pack();
    }

	/**
	 * @param ActionEvent e : �venement provenant d'un clic sue un bouton
	 * @return : void
	 * @description : �coute les �v�nements provenant d'un clic sur bouton - m�thode issue de l'interface ActionListener
	 */
    public void actionPerformed(ActionEvent e) 
	{		
		if (e.getActionCommand().equals("valid")) //l'utilisateur clique sur valider
		{
			this.account = new TeacherFacade(); //on cr�e un nouvel objet compte identifiant un enseignant

				boolean connected = this.account.connect(this.tfLogin.getText(), new String(this.tfMdp.getPassword()));
				
				if (connected)
				{
					this.menu = new MenuView(account);
					this.setVisible(false);
				}
				
				else
				{
					System.out.println("L'utilisateur n'est pas connect�");
					erreur = new MsgPopup("Impossible de se connecter. V�rifiez vos identifiant et mot de passe.");
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
