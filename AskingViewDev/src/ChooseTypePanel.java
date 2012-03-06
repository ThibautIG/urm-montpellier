import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class ChooseTypePanel extends JPanel implements ActionListener
{
	JRadioButton enseignement, reunion;
	JComboBox<String> enseignements;
	
	ChooseTypePanel(TeacherFacade tf)
	{
		ButtonGroup choice = new ButtonGroup(); // Groupe de choix
		
		this.enseignement = new JRadioButton("Enseignement");
		choice.add(this.enseignement);
		this.add(this.enseignement);
		
		this.reunion = new JRadioButton("Réunion");
		choice.add(this.reunion);
		this.add(this.reunion);
		
		this.enseignements = new JComboBox<String>();
		this.add(this.enseignement);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
