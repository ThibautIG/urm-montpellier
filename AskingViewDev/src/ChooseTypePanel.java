import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class ChooseTypePanel extends JPanel
{
	JRadioButton enseignement, reunion;
	JComboBox<String> enseignements;
	
	ChooseTypePanel(TeacherFacade tf)
	{
		this.enseignement = new JRadioButton();
		this.reunion = new JRadioButton();
		this.enseignements = new JComboBox<String>();
		
		
	}
}
