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
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;


class ConsulterView extends JFrame implements ActionListener{
	/**
	 * la semaine à afficher dans l'emploi du temps. Par défaut la semaine en cours
	 */
	private int week;

	public ConsulterView(TeacherFacade c) {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(new BorderLayout(10, 10));

		JLabel lblNewLabel = new JLabel("Consultation du planning");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);

		table = new JTable();
		panel.add(table);
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
			Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}

	/**
	 * Génère l'affichage du calendrier en fonction des séances qu'il reçoit en paramètre.
	 */
	public void genCalendar(Booking listeReservationsValidees) {
	}

	private TeacherFacade account;
	private JTable table;


	public void actionPerformed(ActionEvent arg0) {

	}
}
