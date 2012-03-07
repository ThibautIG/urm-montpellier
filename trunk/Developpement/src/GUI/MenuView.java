package GUI;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import BL.TeacherFacade;


@SuppressWarnings("serial")
class MenuView extends JFrame
{
	private ConsulterView consulting;
	private AskingView Asking;
	private HandlingView Handling;
	
	// Boutons
	private JButton consult, asking;
	
	public  MenuView(TeacherFacade c) 
	{
		this.setTitle("URM");
		this.setSize(200,300);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		this.consult = new JButton("Consulter mon emploi du temps");
		this.getContentPane().add(this.consult);
		
		this.asking = new JButton("Demande de réservation");
		this.getContentPane().add(this.asking);
		
	}
}
