package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import BL.TeacherFacade;
import javax.swing.JTable;
import java.awt.Dimension;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;


class ConsulterView extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * la semaine à afficher dans l'emploi du temps. Par défaut la semaine en cours
	 */
	private int week;
	private TeacherFacade account;
	private JTable table;
	private JButton bPrecedent;
	private JButton bSuivant;
	private JButton bQuit;
	private JPanel quit_panel;
	private JPanel planning_panel;


	@SuppressWarnings("serial")
	public ConsulterView(TeacherFacade c) 
	{
		super("Mon planning");

		this.account = c;
		this.week = 1;

		this.setSize(new Dimension(800, 357));
		getContentPane().setLayout(null);

		planning_panel = new JPanel();
		planning_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		planning_panel.setBounds(10, 10, 764, 282);
		getContentPane().add(planning_panel);
		planning_panel.setLayout(null);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.GRAY, null, null));
		table.setBounds(73, 4, 619, 272);
		table.setBackground(SystemColor.menu);
		planning_panel.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{"Horaires", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"},
						{"8:00 - 9:30", null, null, null, null, null},
						{"9:45 - 10:15", null, null, null, null, null},
						{"10:30 - 11:15", null, null, null, null, null},
						{"11:15 - 13:00", null, null, null, null, null},
						{"13:15 - 14:45", null, null, null, null, null},
						{"15:00 - 16:30", null, null, null, null, null},
						{"16:45 - 18:15", null, null, null, null, null},
						{"18:30 - 20:00", null, null, null, null, null},
				},
				new String[] {
						"Horaires", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
				}
				) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		centrerTable(table);
		
		bPrecedent = new JButton("<");
		bPrecedent.setBounds(9, 113, 58, 46);
		planning_panel.add(bPrecedent);
		bPrecedent.setActionCommand("Precedent");

		bSuivant = new JButton(">");
		bSuivant.setBounds(697, 113, 57, 46);
		planning_panel.add(bSuivant);
		bSuivant.setActionCommand("Suivant");
		bSuivant.addActionListener(this);
		bPrecedent.addActionListener(this);

		quit_panel = new JPanel();
		quit_panel.setBounds(0, 284, 784, 41);
		getContentPane().add(quit_panel);
		quit_panel.setLayout(null);

		bQuit = new JButton("Fermer");
		bQuit.setBounds(680, 9, 94, 23);
		quit_panel.add(bQuit);
		bQuit.setActionCommand("Fermer");
		bQuit.addActionListener(this);
		bQuit.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		this.genCalendar(week);
	}




	/**
	 * Génère l'affichage du calendrier en fonction des séances qu'il reçoit en paramètre.
	 */
	public void genCalendar(int week)
	{
		int i;
		ArrayList<ArrayList<String>> infosPlanning;
		infosPlanning = account.getValidBooking(week);

		for (i=week; i<infosPlanning.size(); i++) //modification de int i = 0 en int i = week
		{
			System.out.println(infosPlanning.get(i).get(3));
			table.setValueAt(infosPlanning.get(i).get(3), i+1, i+1);
		}
	}


	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Suivant")) 
		{
			this.week = this.week++;
			genCalendar(week);
			new MsgPopup("Ok","Semaine" +week);
		}
		else if (e.getActionCommand().equals("Precedent"))  
		{
			this.week = this.week--;
			genCalendar(week);
			new MsgPopup("Ok","Semaine" +week);
		}
		else if (e.getActionCommand().equals("Fermer"))  
		{
			this.setVisible(false);
		}
	}


	private void centrerTable(JTable table) 
	{     
		DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
		custom.setHorizontalAlignment(JLabel.CENTER); 
		for (int i=0 ; i<table.getColumnCount() ; i++) 
			table.getColumnModel().getColumn(i).setCellRenderer(custom); 
	}
}
