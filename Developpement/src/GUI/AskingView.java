package GUI;
import java.awt.Dimension;

import javax.swing.*;

import BL.TeacherFacade;
import com.toedter.calendar.JCalendar;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


@SuppressWarnings("serial")
class AskingView extends JFrame implements ActionListener, ItemListener, PropertyChangeListener, ListSelectionListener
{
        private TeacherFacade account;
        
        // Données récoltées
        private String teachingSelected;
        private Date dateSelected;
        private String scheduleSelected;
        private Enumeration<String> featuresSelected = null;
        private int capacity = 0;
        private String comments = "";
        
        // Widgets
        private final ButtonGroup buttonGroup = new ButtonGroup();
        private JTextField tfCapacity;
        private JComboBox<String> teachingChoice;
        private JCalendar calendar;
        private JList<String> schedulesList, lSelectedFt, lUnselectedFt;
        private JTextArea taComments;
        private JLabel lblNbRooms;

        AskingView(TeacherFacade account) 
        {
                super("Demande de réservation");
                this.account = account;
                
                // Construction de la fenêtre
                setResizable(false);
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                getContentPane().setLayout(null);
                this.setSize(new Dimension(460, 560));
                
                // Panneau de choix du type de réservation
                JPanel chooseType = new JPanel();
                chooseType.setBounds(0, 0, 452, 53);
                chooseType.setBackground(SystemColor.menu);
                getContentPane().add(chooseType);
                chooseType.setLayout(null);
                
                JRadioButton rdbtnTeaching = new JRadioButton("Enseignement");
                rdbtnTeaching.setActionCommand("teach");
                rdbtnTeaching.addActionListener(this);
                rdbtnTeaching.setBounds(132, 0, 118, 23);
                buttonGroup.add(rdbtnTeaching);
                chooseType.add(rdbtnTeaching);
                
                JRadioButton rdbtnMeeting = new JRadioButton("R\u00E9union");
                rdbtnMeeting.setActionCommand("meet");
                rdbtnMeeting.addActionListener(this);
                rdbtnMeeting.setBounds(253, 0, 94, 23);
                buttonGroup.add(rdbtnMeeting);
                chooseType.add(rdbtnMeeting);
                
                teachingChoice = new JComboBox<String>();
                teachingChoice.setEnabled(false);
                teachingChoice.addItemListener(this);
                teachingChoice.setBounds(133, 28, 186, 23);
                chooseType.add(teachingChoice);
                
                // Panneau de la date et du créneau
                JPanel timeAndDate = new JPanel();
                timeAndDate.setBounds(0, 53, 452, 164);
                getContentPane().add(timeAndDate);
                timeAndDate.setLayout(null);
                
                calendar = new JCalendar();
                calendar.addPropertyChangeListener(this);
                calendar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                calendar.setBounds(10, 6, 205, 153);
                timeAndDate.add(calendar);
                
                JLabel lblSelectSchedule = new JLabel("Selection du cr\u00E9neau :");
                lblSelectSchedule.setBounds(246, 6, 146, 14);
                timeAndDate.add(lblSelectSchedule);
                
                schedulesList = new JList<String>();
                DefaultListModel<String> dlms = new DefaultListModel<String>();
                ArrayList<String> als = this.account.getSchedules();
                for (int i=0; i<als.size(); i++)
                {
                        dlms.addElement(als.get(i));
                }
                this.schedulesList.setModel(dlms);
                schedulesList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                schedulesList.setBounds(246, 19, 196, 140);
                this.schedulesList.addListSelectionListener(this);
                timeAndDate.add(schedulesList);
                
                // Panneau des caractéristiques
                JPanel features = new JPanel();
                features.setBounds(0, 222, 442, 174);
                features.setBorder(new TitledBorder(null, "Caract\u00E9ristiques", TitledBorder.LEFT, TitledBorder.TOP, null, null));
                features.setBackground(SystemColor.menu);
                getContentPane().add(features);
                features.setLayout(null);
                
                JButton bAddFeature = new JButton(">");
                bAddFeature.setActionCommand("add");
                bAddFeature.addActionListener(this);
                bAddFeature.setBounds(200, 35, 41, 23);
                features.add(bAddFeature);
                
                JButton bDelFeature = new JButton("<");
                bDelFeature.setActionCommand("del");
                bDelFeature.addActionListener(this);
                bDelFeature.setBounds(200, 101, 41, 23);
                features.add(bDelFeature);
                
                JLabel lblCapacity = new JLabel("Capacit\u00E9 :");
                lblCapacity.setBounds(10, 150, 110, 14);
                features.add(lblCapacity);
                
                tfCapacity = new JTextField();
                tfCapacity.setText("0");
                tfCapacity.setBounds(71, 147, 86, 20);
                features.add(tfCapacity);
                tfCapacity.setColumns(10);
                
                lSelectedFt = new JList<String>();
                this.lSelectedFt.setModel(new DefaultListModel<String>());
                lSelectedFt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                lSelectedFt.setBounds(252, 21, 180, 118);
                features.add(lSelectedFt);
                
                lUnselectedFt = new JList<String>();
                DefaultListModel<String> dlm = new DefaultListModel<String>();
                ArrayList<String> fts = this.account.getFeatures(); 
                for (int i=0; i<fts.size(); i++)
                {
                	dlm.addElement(fts.get(i));
                }
                this.lUnselectedFt.setModel(dlm);
                lUnselectedFt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                lUnselectedFt.setBounds(10, 21, 180, 118);
                features.add(lUnselectedFt);
                
                // Panneau des commentaires
                JPanel commentsPanel = new JPanel();
                commentsPanel.setBounds(0, 401, 452, 37);
                getContentPane().add(commentsPanel);
                commentsPanel.setLayout(null);
                
                JLabel lblComments = new JLabel("Commentaires :");
                lblComments.setBounds(10, 5, 147, 14);
                commentsPanel.add(lblComments);
                
                taComments = new JTextArea();
                taComments.setBounds(116, 0, 326, 37);
                commentsPanel.add(taComments);
                
                // Panneau du nombre de salles libres
                JPanel roomNb = new JPanel();
                roomNb.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
                roomNb.setBounds(55, 447, 344, 37);
                roomNb.setBackground(SystemColor.menu);
                getContentPane().add(roomNb);
                roomNb.setLayout(null);
                
                lblNbRooms = new JLabel("Nombre de salles disponibles estim\u00E9 : ? ");
                lblNbRooms.setBounds(10, 11, 291, 14);
                roomNb.add(lblNbRooms);
                
                JButton bCheck = new JButton("V\u00E9rifier");
                bCheck.setActionCommand("ck");
                bCheck.addActionListener(this);
                bCheck.setBounds(246, 8, 88, 20);
                roomNb.add(bCheck);
                
                // Panneau des boutons de validation et annulation
                JPanel finish = new JPanel();
                finish.setBounds(125, 487, 203, 34);
                getContentPane().add(finish);
                finish.setLayout(null);
                
                JButton bCancel = new JButton("Annuler");
                bCancel.setActionCommand("cancel");
                bCancel.addActionListener(this);
                bCancel.setBounds(10, 5, 86, 23);
                finish.add(bCancel);
                
                JButton bValid = new JButton("Valider");
                bValid.setActionCommand("valid");
                bValid.addActionListener(this);
                bValid.setBounds(106, 5, 87, 23);
                finish.add(bValid);
                
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                this.setVisible(true);
        }


        @Override
        public void actionPerformed(ActionEvent e) 
        {
                if(e.getActionCommand().equals("teach"))
                {
                        ArrayList<String> ens = this.account.getTeachings();
                        
                        for(int i=0; i < ens.size(); i++)
                        {
                            this.teachingChoice.addItem(ens.get(i));
                        }
                        
                        this.teachingChoice.setEnabled(true);
                }
                else if(e.getActionCommand().equals("meet"))
                {
                        this.teachingChoice.setEnabled(false);
                        this.teachingChoice.removeAllItems();
                }
                else if(e.getActionCommand().equals("add"))
                {
                        if(!this.lUnselectedFt.isSelectionEmpty())
                        {
                                DefaultListModel<String> dlm = (DefaultListModel<String>)this.lSelectedFt.getModel();
                                dlm.addElement(this.lUnselectedFt.getSelectedValue());
                                this.lSelectedFt.setModel(dlm);
                                
                                this.featuresSelected = ((DefaultListModel<String>)this.lSelectedFt.getModel()).elements();
                                
                                
                                DefaultListModel<String> dlm2 = (DefaultListModel<String>)this.lUnselectedFt.getModel();
                                dlm2.removeElementAt(this.lUnselectedFt.getSelectedIndex());
                                this.lUnselectedFt.setModel(dlm2);
                        }
                }
                else if(e.getActionCommand().equals("del"))
                {
                        if(!this.lSelectedFt.isSelectionEmpty())
                        {
                                DefaultListModel<String> dlm = (DefaultListModel<String>)this.lUnselectedFt.getModel();
                                dlm.addElement(this.lSelectedFt.getSelectedValue());
                                this.lUnselectedFt.setModel(dlm);
                                
                                DefaultListModel<String> dlm2 = (DefaultListModel<String>)this.lSelectedFt.getModel();
                                dlm2.removeElementAt(this.lSelectedFt.getSelectedIndex());
                                this.lSelectedFt.setModel(dlm2);
                                this.featuresSelected = dlm2.elements();
                        }
                }
                else if(e.getActionCommand().equals("ck"))
                {
                        if(this.dateSelected != null && this.scheduleSelected != null)
                        {
                                this.capacity = 0 + Integer.parseInt(this.tfCapacity.getText());
                                this.lblNbRooms.setText("Nombre de salles disponibles estim\u00E9 : "+this.account.checkFreeRooms(this.dateSelected, this.scheduleSelected, this.featuresSelected, this.capacity));
                        }
                }
                else if(e.getActionCommand().equals("cancel"))
                {
                        dispose();
                }
                else if(e.getActionCommand().equals("valid"))
                {
                        if(this.teachingSelected != null)
                        {
                                if(this.dateSelected != null && this.scheduleSelected != null)
                                {
                                        this.capacity = Integer.parseInt(this.tfCapacity.getText());
                                        this.comments = this.taComments.getText();
                                        this.account.confirmBooking(teachingSelected, dateSelected, scheduleSelected, featuresSelected, capacity, comments);
                                        dispose();
                                }
                        }
                }
        }

        @Override
        public void itemStateChanged(ItemEvent i) 
        {
                this.teachingSelected = (String) i.getItem();           
        }


        @Override
        public void valueChanged(ListSelectionEvent arg0) 
        {
                this.scheduleSelected = (String) this.schedulesList.getSelectedValue();
        }


        @Override
        public void propertyChange(PropertyChangeEvent arg0) 
        {
                this.dateSelected = this.calendar.getDate();
        }
}
