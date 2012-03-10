

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FeaturePanel extends JPanel implements ActionListener
{
	private TeacherFacade tf;
	private JList<String> selectedFeatures;
	private JList<String> unselectedFeatures;
	private JButton addFeature, delFeature;

	FeaturePanel(TeacherFacade tf) 
	{
		// Création de la liste des caractéristiques non selectionnées
		DefaultListModel<String> dlm1 = new DefaultListModel<String>();
		dlm1.addElement("Amphi");
		dlm1.addElement("Projecteur");
		this.unselectedFeatures = new JList<String>(dlm1);
		this.add(this.unselectedFeatures);
		
		// Création du bouton d'ajout
		this.addFeature = new JButton(">");
		this.addFeature.setActionCommand("add");
		this.addFeature.addActionListener(this);
		this.add(this.addFeature);
		
		// Création du bouton de déselection d'une caractéristique
		this.delFeature = new JButton("<");
		this.delFeature.setActionCommand("del");
		this.delFeature.addActionListener(this);
		this.add(this.delFeature);
		
		// Création de la liste des caractéristiques sélectionnées
		DefaultListModel<String> dlm2 = new DefaultListModel<String>();
		dlm2.addElement("Tableau blanc");
		this.selectedFeatures = new JList<String>(dlm2);
		this.add(this.selectedFeatures);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("add"))
		{
			DefaultListModel<String> dlm = (DefaultListModel<String>)this.selectedFeatures.getModel();
			dlm.addElement(this.unselectedFeatures.getSelectedValue());
			dlm = (DefaultListModel<String>)this.unselectedFeatures.getModel();
			dlm.removeElementAt(this.unselectedFeatures.getSelectedIndex());
		}
		else if(e.getActionCommand().equals("del"))
		{
			DefaultListModel<String> dlm = (DefaultListModel<String>)this.unselectedFeatures.getModel();
			dlm.addElement(this.selectedFeatures.getSelectedValue());
			dlm = (DefaultListModel<String>)this.selectedFeatures.getModel();
			dlm.removeElementAt(this.selectedFeatures.getSelectedIndex());
		}
	}

}
