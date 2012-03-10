package GUI;
import java.awt.Dimension;

import javax.swing.*;
import BL.TeacherFacade;


@SuppressWarnings("serial")
class AskingView extends JFrame
{
	// Données récoltées
	private TeacherFacade account;
	private String featuresSelected;
	private String scheduleSelected;
	private String dateSelected;
	private String teachingSelected;
	private int capacity;
	private String comments;


	AskingView(TeacherFacade account) 
	{
		super("Demande de réservation");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
