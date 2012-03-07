import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class FeaturePanel extends JPanel implements ActionListener
{
	private TeacherFacade tf;
	private JList<String> selectedFeatures;
	private JList<String> unselectedFeatures;
	private JButton addFeature, delFeature;

	FeaturePanel(TeacherFacade tf) 
	{
		DefaultListModel<String> dlm1 = new DefaultListModel<String>();
		this.unselectedFeatures = new JList<String>(dlm1);
		this.add(this.unselectedFeatures);
		
		this.addFeature = new JButton(">");
		this.addFeature.setActionCommand("add");
		this.addFeature.addActionListener(this);
		this.add(this.addFeature);
		
		this.delFeature = new JButton("<");
		this.delFeature.setActionCommand("del");
		this.delFeature.addActionListener(this);
		this.add(this.delFeature);
		
		DefaultListModel<String> dlm2 = new DefaultListModel<String>();
		this.selectedFeatures = new JList<String>(dlm2);
		this.add(this.selectedFeatures);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("add"))
		{
			this.unselectedFeatures.getSelectedValue();
		}
		else if(e.getActionCommand().equals("del"))
		{
			
		}
	}

}
