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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;


class ConsulterView extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * la semaine � afficher dans l'emploi du temps. Par d�faut la semaine en cours
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

		this.setSize(new Dimension(965, 357));
		getContentPane().setLayout(null);

		planning_panel = new JPanel();
		planning_panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		planning_panel.setBounds(10, 10, 929, 282);
		getContentPane().add(planning_panel);
		planning_panel.setLayout(null);

		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.GRAY, null, null));
		table.setBounds(73, 4, 783, 272);
		table.setBackground(SystemColor.menu);
		planning_panel.add(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{"Horaires", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"},
						{"8h00 - 9h30", null, null, null, null, null, null, null},
						{"9h45 - 11h15", null, null, null, null, null, null, null},
						{"11h30 - 13h00", null, null, null, null, null, null, null},
						{"13h15 - 14h45", null, null, null, null, null, null, null},
						{"15h00 - 16h30", null, null, null, null, null, null, null},
						{"16h45 - 18h15", null, null, null, null, null, null, null},
						{"18h30 - 20h00", null, null, null, null, null, null, null},
				},
				new String[] {
						"Horaires", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"
				}
				) {
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setRowHeight(30);
		centrerTable(table);

		bPrecedent = new JButton("<");
		bPrecedent.setBounds(9, 113, 58, 46);
		planning_panel.add(bPrecedent);
		bPrecedent.setActionCommand("Precedent");

		bSuivant = new JButton(">");
		bSuivant.setBounds(862, 113, 57, 46);
		planning_panel.add(bSuivant);
		bSuivant.setActionCommand("Suivant");
		bSuivant.addActionListener(this);
		bPrecedent.addActionListener(this);

		quit_panel = new JPanel();
		quit_panel.setBounds(0, 284, 939, 41);
		getContentPane().add(quit_panel);
		quit_panel.setLayout(null);

		bQuit = new JButton("Fermer");
		bQuit.setBounds(845, 9, 94, 23);
		quit_panel.add(bQuit);
		bQuit.setActionCommand("Fermer");
		bQuit.addActionListener(this);
		bQuit.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		Calendar cal = new GregorianCalendar();
		java.util.Date date= cal.getTime();
		SimpleDateFormat weekNum = new SimpleDateFormat("w");

		this.week = Integer.parseInt(weekNum.format(date));	
		this.genCalendar(week);
	}




	/**
	 * G�n�re l'affichage du calendrier en fonction des s�ances qu'il re�oit en param�tre.
	 */
	public void genCalendar(int week)
	{
		int i;
		ArrayList<ArrayList<String>> infosPlanning;
		infosPlanning = account.getValidBooking(week);

		Calendar cal = new GregorianCalendar();
		initPlaning();
		init_labels(week);
		for (i=0; i<infosPlanning.size(); i++) //modification de int i = 0 en int i = week
		{
			//DATE
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" );
			try {
				Date date = dateFormat.parse(infosPlanning.get(i).get(0));
				cal.setTime(date);

				// CRENEAU
				int cren = 1;
				while(cren<table.getRowCount() && ((String) table.getValueAt(cren,0)).startsWith(infosPlanning.get(i).get(1))==false)
				{
					++cren;
				}
				if (cren<table.getRowCount()) 
				{
					if (cal.get(Calendar.DAY_OF_WEEK) == 1) /* qui correspond a SUNDAY */
					{
						table.setValueAt(infosPlanning.get(i).get(3), cren, cal.get(Calendar.DAY_OF_WEEK)+6);
					}
					else
					{
						table.setValueAt(infosPlanning.get(i).get(3), cren, cal.get(Calendar.DAY_OF_WEEK)-1);
					}

				}
				else 
				{
					System.out.println("Creneau inexistant!");
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}


	private void init_labels(int week)
	{
		Calendar cal = new GregorianCalendar();
		String days[] = {"Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi","Dimanche"};

		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setMinimalDaysInFirstWeek(7);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		for(int i=1;i<=days.length;i++)
		{
			table.setValueAt(days[i-1]+" "+cal.get(Calendar.DAY_OF_MONTH)+"/"+(cal.get(Calendar.MONTH)+1),0,i);
			cal.add(Calendar.DAY_OF_WEEK,1);
		}
	}


	private void initPlaning() 
	{
		int i,j;
		for(i=1; i<table.getRowCount(); i++)
		{
			for(j=1; j<table.getColumnCount();j++) 
			{
				table.setValueAt(null,i,j);
			}
		}
	}


	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Suivant")) 
		{
			this.week++;
			genCalendar(week);
		}
		else if (e.getActionCommand().equals("Precedent"))  
		{
			this.week--;
			genCalendar(week);
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
