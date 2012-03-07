import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.toedter.calendar.JCalendar;


@SuppressWarnings("serial")
public class TimePanel extends JPanel implements PropertyChangeListener, ListSelectionListener
{
	private TeacherFacade tf;
	private JCalendar cal;
	private JList<String> sc;
	
	// Données récoltées
	private Date dateSelected;
	private String scheduleSelected;

	public TimePanel(TeacherFacade tf) 
	{
		this.tf = tf;	
		
		// Calendrier
		this.cal = new JCalendar();
		this.cal.addPropertyChangeListener(this);
		this.add(this.cal);
		
		// Créneaux
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		this.sc = new JList<String>(dlm);
		
		//ArrayList<String> scs = this.tf.getSchedules();
		//for(int i=0; i < scs.size(); i++)
		//{
			//dlm.addElement(scs.get(i));
		//}
		
		this.sc.addListSelectionListener(this);
		this.add(this.sc);
	}

	public void propertyChange(PropertyChangeEvent arg0) 
	{
		this.dateSelected = this.cal.getDate();
	}

	public void valueChanged(ListSelectionEvent arg0) 
	{
		this.scheduleSelected = this.sc.getSelectedValue();
	}
	
	Date getDate()
	{
		return this.dateSelected;
	}
	
	String getSchedule()
	{
		return this.scheduleSelected;
	}

}
