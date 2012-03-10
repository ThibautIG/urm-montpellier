package GUI;
import java.awt.Dimension;

import javax.swing.*;
import BL.TeacherFacade;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JCalendar;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;


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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfCapacity;


	AskingView(TeacherFacade account) 
	{
		super("Demande de réservation");
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(new Dimension(460, 560));
		
		JPanel chooseType = new JPanel();
		chooseType.setBounds(0, 0, 452, 53);
		chooseType.setBackground(SystemColor.menu);
		getContentPane().add(chooseType);
		chooseType.setLayout(null);
		
		JRadioButton rdbtnTeaching = new JRadioButton("Enseignement");
		rdbtnTeaching.setBounds(147, 0, 93, 23);
		buttonGroup.add(rdbtnTeaching);
		chooseType.add(rdbtnTeaching);
		
		JRadioButton rdbtnMeeting = new JRadioButton("R\u00E9union");
		rdbtnMeeting.setBounds(242, 0, 65, 23);
		buttonGroup.add(rdbtnMeeting);
		chooseType.add(rdbtnMeeting);
		
		JComboBox teachingChoice = new JComboBox();
		teachingChoice.setBounds(144, 28, 163, 23);
		chooseType.add(teachingChoice);
		
		JPanel timeAndDate = new JPanel();
		timeAndDate.setBounds(0, 53, 452, 164);
		getContentPane().add(timeAndDate);
		timeAndDate.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		calendar.setBounds(10, 6, 205, 153);
		timeAndDate.add(calendar);
		
		JLabel lblSelectSchedule = new JLabel("Selection du cr\u00E9neau :");
		lblSelectSchedule.setBounds(246, 6, 107, 14);
		timeAndDate.add(lblSelectSchedule);
		
		JList schedulesList = new JList();
		schedulesList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		schedulesList.setBounds(246, 19, 196, 140);
		timeAndDate.add(schedulesList);
		DefaultListModel<String> lm = new DefaultListModel<String>();
		lm.addElement("8h00 - 9h30");
		lm.addElement("9h45 - 11h15");
		
		JPanel features = new JPanel();
		features.setBounds(0, 222, 442, 174);
		features.setBorder(new TitledBorder(null, "Caract\u00E9ristiques", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		features.setBackground(SystemColor.menu);
		getContentPane().add(features);
		features.setLayout(null);
		
		JButton bAddFeature = new JButton(">");
		bAddFeature.setBounds(200, 35, 41, 23);
		features.add(bAddFeature);
		
		JButton bDelFeature = new JButton("<");
		bDelFeature.setBounds(200, 80, 41, 23);
		features.add(bDelFeature);
		
		JLabel lblCapacity = new JLabel("Capacit\u00E9 :");
		lblCapacity.setBounds(10, 150, 51, 14);
		features.add(lblCapacity);
		
		tfCapacity = new JTextField();
		tfCapacity.setBounds(71, 147, 86, 20);
		features.add(tfCapacity);
		tfCapacity.setColumns(10);
		
		JList lSelectedFt = new JList();
		lSelectedFt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lSelectedFt.setBounds(10, 21, 180, 118);
		features.add(lSelectedFt);
		
		JList lUnselectedFt = new JList();
		lUnselectedFt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lUnselectedFt.setBounds(252, 21, 180, 118);
		features.add(lUnselectedFt);
		
		JPanel commentsPanel = new JPanel();
		commentsPanel.setBounds(0, 401, 452, 37);
		getContentPane().add(commentsPanel);
		commentsPanel.setLayout(null);
		
		JLabel lblComments = new JLabel("Commentaires :");
		lblComments.setBounds(10, 5, 75, 14);
		commentsPanel.add(lblComments);
		
		JTextArea taComments = new JTextArea();
		taComments.setBounds(95, 0, 347, 37);
		commentsPanel.add(taComments);
		
		JPanel roomNb = new JPanel();
		roomNb.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		roomNb.setBounds(85, 447, 282, 37);
		roomNb.setBackground(SystemColor.menu);
		getContentPane().add(roomNb);
		roomNb.setLayout(null);
		
		JLabel lblNbRooms = new JLabel("Nombre de salles disponibles estim\u00E9 : 0 ");
		lblNbRooms.setBounds(10, 11, 189, 14);
		roomNb.add(lblNbRooms);
		
		JButton bCheck = new JButton("V\u00E9rifier");
		bCheck.setBounds(209, 8, 67, 20);
		roomNb.add(bCheck);
		
		JPanel finish = new JPanel();
		finish.setBounds(141, 490, 169, 34);
		getContentPane().add(finish);
		finish.setLayout(null);
		
		JButton bCancel = new JButton("Annuler");
		bCancel.setBounds(10, 5, 69, 23);
		finish.add(bCancel);
		
		JButton bValid = new JButton("Valider");
		bValid.setBounds(89, 5, 65, 23);
		finish.add(bValid);
		
		this.setVisible(true);
	}
}
