package GUI;
import java.awt.Dimension;

import javax.swing.*;
import BL.TeacherFacade;


@SuppressWarnings("serial")
class AskingView extends JFrame
{
	// Donn�es r�colt�es
	private TeacherFacade account;
	private String featuresSelected;
	private String scheduleSelected;
	private String dateSelected;
	private String teachingSelected;
	private int capacity;
	private String comments;


	AskingView(TeacherFacade account) 
	{
		super("Demande de r�servation");
		this.setSize(new Dimension(800, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
