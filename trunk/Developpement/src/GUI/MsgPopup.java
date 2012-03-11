package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MsgPopup extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton okButton;
	JLabel msgToDisplay;
	JPanel pNorth, pSouth;
	
	public MsgPopup(String title, String msg)
	{
		initComponents(title, "\t"+msg+"\t");
	}
	

	private void initComponents(String title, String msg)
	{
		this.setSize(300,300);
		this.setTitle("Erreur");
		okButton = new JButton ("Ok"); okButton.setActionCommand("ok"); okButton.addActionListener(this); //création et initialisation du bouton "valider"
		msgToDisplay = new JLabel (msg);
		pNorth = new JPanel (new BorderLayout());
		pSouth = new JPanel (new BorderLayout());
		pNorth.add(msgToDisplay);
		pSouth.add(okButton);
		
		this.getContentPane().add(pNorth, BorderLayout.NORTH); //On ajoute un panneau au Nord
		this.getContentPane().add(pSouth, BorderLayout.SOUTH); //On ajoute un panneau au sud
		
		this.setResizable(false);
    	this.setLocationRelativeTo(null); //on place la fenêtre au centre de l'écran    
        this.setVisible(true); //la fenêtre est rendue visible
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("ok"))
		{
			this.setVisible(false);
		}
		
	}

}
