package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import BL.TeacherFacade;

@SuppressWarnings("serial")
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

    public LoginView() 
    {
    	setResizable(false);
        initComponents();
    }

    private void initComponents() 
    {
    	//initialisation des widgets
    	this.setTitle("URM Authentification");
    	this.setSize(384,232);
    	
		/** construction du panneau nord */
    	pNorth = new JPanel (new GridLayout(2,2)); //panneau nord
    	
    	lblLogin = new JLabel("Login :"); //label Login
    	tfLogin = new JTextField();
    	tfLogin.setPreferredSize(new Dimension (90, 20));
    	tfLogin.setToolTipText("Enter your login");

    	lblMdp = new JLabel("Mot de passe :"); //label mot de passe
    	tfMdp = new JPasswordField();
    	tfMdp.setPreferredSize(new Dimension (90, 20));
    	tfMdp.setToolTipText("Enter your password");
    	
    	/** ajout des widgets du panneau nord */
    	
    	pNorth.add(lblLogin);
    	pNorth.add(tfLogin);
    	pNorth.add(lblMdp);
    	pNorth.add(tfMdp);
    	
		/** construction du panneau sud */

    	pSouth = new JPanel (); //panneau sud
    	
    	bValid = new JButton("Valider"); bValid.setActionCommand("valid"); bValid.addActionListener(this);
    	bCancel = new JButton("Annuler"); bCancel.setActionCommand("cancel"); bCancel.addActionListener(this);
    	
    	/** ajout des widgets du panneau sud */
    	
    	pSouth.add(bValid);
    	pSouth.add(bCancel);
    	
    	/** ajout des panneaux à la fenêtre */
    	this.getContentPane().add(pNorth, BorderLayout.NORTH); //On ajoute un panneau au nord
    	this.getContentPane().add(pSouth, BorderLayout.SOUTH); //On ajoute un panneau au sud
    	
    	this.setLocationRelativeTo(null);     
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }

	public void actionPerformed(ActionEvent e) 
	{		
		if (e.getActionCommand().equals("valid"))
		{
			this.account = new TeacherFacade();
			
			boolean connected = this.account.connect(this.tfLogin.getText(), new String(this.tfMdp.getPassword()));
			if (!connected)
			{
				System.out.println("L'utilisateur n'est pas connecté");
			}
			else
			{
				this.menu = new MenuView(account);
				this.setVisible(false);
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
