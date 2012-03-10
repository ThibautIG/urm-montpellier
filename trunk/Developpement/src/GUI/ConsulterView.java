package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import BL.Booking;
import BL.TeacherFacade;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.util.ArrayList;


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

	private JPanel Boutons_panel;
	private JTable table;
	private JButton bPrecedent;
	private JButton bSuivant;
	private JPanel panel;
	private JButton bQuit;
	private JPanel quit_panel;
	private JPanel planning_panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;


	@SuppressWarnings("serial")
	public ConsulterView(TeacherFacade c) 
	{
		super("Consultation Planning");

		this.account = c;

		this.setSize(new Dimension(800, 600));
		getContentPane().setLayout(new BorderLayout(0, 19));

		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(50, 50));
		getContentPane().add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("Consultation du planning");
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		planning_panel = new JPanel();
		getContentPane().add(planning_panel, BorderLayout.CENTER);
		planning_panel.setLayout(new BorderLayout(10, 10));

		table = new JTable();
		table.setBackground(Color.WHITE);
		planning_panel.add(table, BorderLayout.NORTH);
		table.setModel(new DefaultTableModel(
				new Object[][] {
						{"Horaires", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"},
						{"8:00 - 9:30", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"9:45 - 10:15", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"10:30 - 11:15", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"11:15 - 13:00", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"13:15 - 14:45", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"15:00 - 16:30", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"16:45 - 18:15", null, null, null, null, null},
						{null, null, null, null, null, null},
						{"18:30 - 20:00", null, null, null, null, null},
						{null, null, null, null, null, null},
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
					false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		Boutons_panel = new JPanel();
		Boutons_panel.setMinimumSize(new Dimension(20, 20));
		planning_panel.add(Boutons_panel, BorderLayout.SOUTH);

		bPrecedent = new JButton("<  Precedent");
		bPrecedent.setActionCommand("Precedent");
		bPrecedent.addActionListener(this);
		Boutons_panel.setLayout(new BorderLayout(0, 5));
		Boutons_panel.add(bPrecedent, BorderLayout.WEST);

		bSuivant = new JButton("Suivant  >");
		bSuivant.setActionCommand("Suivant");
		bSuivant.addActionListener(this);
		Boutons_panel.add(bSuivant, BorderLayout.EAST);

		quit_panel = new JPanel();
		getContentPane().add(quit_panel, BorderLayout.SOUTH);
		quit_panel.setLayout(new BoxLayout(quit_panel, BoxLayout.X_AXIS));

		panel = new JPanel();
		quit_panel.add(panel);
		panel.setLayout(new BorderLayout(20, 0));

		bQuit = new JButton("Fermer");
		bQuit.setActionCommand("Fermer");
		bQuit.addActionListener(this);
		panel.add(bQuit, BorderLayout.EAST);
		bQuit.setAlignmentX(Component.RIGHT_ALIGNMENT);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

		this.genCalendar(1);
	}




	/**
	 * Génère l'affichage du calendrier en fonction des séances qu'il reçoit en paramètre.
	 */
	public void genCalendar(int week)
	{
		int i;
		ArrayList<ArrayList<String>> infosPlanning;
		infosPlanning = account.getValidBooking(week);

		for (i=0; i<infosPlanning.size(); i++){
			System.out.println(infosPlanning.get(i).get(3));
			table.setValueAt(infosPlanning.get(i).get(3), i+1, i+1);
		}
	}


public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	if (source instanceof JButton){
		if (source == bSuivant) {
			week = week++;
		}
		else if (source == bPrecedent) {
			week = week--;
		}
		else if (source == bQuit) {
			this.setVisible(false);
		}
	}
}
}
