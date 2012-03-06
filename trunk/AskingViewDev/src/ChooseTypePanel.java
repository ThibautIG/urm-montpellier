import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

@SuppressWarnings("serial")
class ChooseTypePanel extends JPanel implements ActionListener, ItemListener
{
	private JRadioButton enseignement, reunion;
	private JComboBox<String> enseignements;
	private TeacherFacade tf;
	
	// Données récoltées
	private String teachingSelected;
	
	ChooseTypePanel(TeacherFacade tf)
	{	
		ButtonGroup choice = new ButtonGroup(); // Groupe de choix
		this.tf = tf;
		
		// Choix réservation d'enseignement
		this.enseignement = new JRadioButton("Enseignement");
		this.enseignement.setActionCommand("enseignement");
		choice.add(this.enseignement);
		this.enseignement.addActionListener(this);
		this.add(this.enseignement);
		
		// Choix réservation réunion
		this.reunion = new JRadioButton("Réunion");
		this.reunion.setActionCommand("reunion");
		choice.add(this.reunion);
		this.add(this.reunion);
		
		// Liste déroulante des enseignements
		this.enseignements = new JComboBox<String>();
		this.enseignements.addItem("Enseignements");
		this.enseignements.addItem("Enseignements1");
		this.enseignements.setEnabled(false);
		this.enseignements.addItemListener(this);
		this.add(this.enseignements);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("enseignement"))
		{
			//ArrayList<String> ens = this.tf.getTeaching();
			
			//for(int i=0; i < ens.size(); i++)
			//{
				//this.enseignements.addItem(ens.get(i));
			//}
			
			this.enseignements.setEnabled(true);
		}
		else if(e.getActionCommand().equals("reunion"))
		{
			
		}
	}

	public void itemStateChanged(ItemEvent i) 
	{
		this.teachingSelected = (String) i.getItem();
	}
	
	String getTeachingSelected()
	{
		return this.teachingSelected;
	}
}
