package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import database.*;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TeamView extends JFrame {
	private JPanel contentPane;
	private JPanel contentPane_1;
    private JTable teamsTable;
    private JTextField tfDateOfSubmit;
    private ArrayList<Team> teams = new ArrayList<>();
	private TeamDAO teamDAO = new TeamDAO();
	private Project project;
	

	/**
	 * Create the frame.
	 */
	public TeamView(Project project) {
		this.project = project;
		this.updateTeamsTable();

		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectView.class.getResource("/util/resources/iconn.png")));
		setTitle("Teams");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 650);
		setResizable(false);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				dispose();
				HomeView homePage = new HomeView();
				homePage.setVisible(true);
			}
		});
		
		mnHome.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		menuBar.add(mnHome);
		
		JMenu mnProjects = new JMenu("Projects");
		mnProjects.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				dispose();
				ProjectView projectPage = new ProjectView();
				projectPage.setVisible(true);
			}
		});
		
		mnProjects.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		menuBar.add(mnProjects);
		
		JMenu mnStudents = new JMenu("Students");
		mnStudents.addMenuListener(new MenuListener() {
			public void menuCanceled(MenuEvent e) {
			}
			public void menuDeselected(MenuEvent e) {
			}
			public void menuSelected(MenuEvent e) {
				dispose();
				StudentView studentPage = new StudentView();
				studentPage.setVisible(true);
			}
		});
		
		mnStudents.setFont(new Font("Segoe UI", Font.PLAIN, 19));
		menuBar.add(mnStudents);
		contentPane_1 = new JPanel();
		contentPane_1.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane_1);
		
		JPanel InfoPanel = new JPanel();
		
		JPanel CreatePanel = new JPanel();
		
		JPanel listPanel = new JPanel();
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(CreatePanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(InfoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(listPanel, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(listPanel, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addComponent(InfoPanel, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(CreatePanel, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JLabel lblTeams = new JLabel("Teams");
		lblTeams.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnGrade = new JButton("Grade");
		
		btnGrade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnDateOfSubmit = new JButton("Set Date of Submission");
		
		btnDateOfSubmit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
						.addGroup(gl_listPanel.createSequentialGroup()
							.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_listPanel.createSequentialGroup()
									.addComponent(lblTeams, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
									.addGap(51))
								.addGroup(gl_listPanel.createSequentialGroup()
									.addComponent(btnDelete)
									.addGap(57)))
							.addComponent(btnGrade)
							.addGap(43)
							.addComponent(btnDateOfSubmit)))
					.addContainerGap())
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTeams, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 464, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_listPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_listPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDateOfSubmit)
							.addComponent(btnGrade))
						.addComponent(btnDelete))
					.addContainerGap())
		);
		
		
		teamsTable = new JTable();
		

		teamsTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(teamsTable);
		
		String[] columnNames = {"Student 1", "Student 2", "Date of Submission"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		for (Team team : teams) {
				Object[] rowData = {team.getStudent1().getFullName(), team.getStudent2().getFullName(), team.getDateOfSubmit()};
		    model.addRow(rowData);
		    
		}

		teamsTable.setModel(model);
		
		listPanel.setLayout(gl_listPanel);
		
		JButton btnAdd = new JButton("Add");
		
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCreate = new JLabel("Please enter information");
		lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblStudent1 = new JLabel("Student 1 : ");
		lblStudent1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblStudent2 = new JLabel("Student 2 :");
		lblStudent2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblDateOfSubmit = new JLabel("Date of submit : ");
		lblDateOfSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfDateOfSubmit = new JTextField();
		tfDateOfSubmit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfDateOfSubmit.setColumns(10);
		
		JComboBox<Integer> cbStudent1 = new JComboBox<Integer>();
        cbStudent1.addItem(0);

		StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> students = studentDAO.getAll();
        for (Student student : students) {
            cbStudent1.addItem(student.getId());
        }
		cbStudent1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox<Integer> cbStudent2 = new JComboBox<Integer>();
        cbStudent2.addItem(0);
        for (Student student : students) {
        	
                cbStudent2.addItem(student.getId());
        	
        }
		cbStudent2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel = new JLabel("(YYYY-MM-DD)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_CreatePanel = new GroupLayout(CreatePanel);
		gl_CreatePanel.setHorizontalGroup(
			gl_CreatePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CreatePanel.createSequentialGroup()
					.addContainerGap(301, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addGap(24))
				.addGroup(gl_CreatePanel.createSequentialGroup()
					.addGap(85)
					.addComponent(lblCreate, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(43, Short.MAX_VALUE))
				.addGroup(gl_CreatePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDateOfSubmit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tfDateOfSubmit, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_CreatePanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_CreatePanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_CreatePanel.createSequentialGroup()
							.addComponent(lblStudent1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbStudent1, 0, 278, Short.MAX_VALUE))
						.addGroup(gl_CreatePanel.createSequentialGroup()
							.addComponent(lblStudent2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbStudent2, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_CreatePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(253, Short.MAX_VALUE))
		);
		gl_CreatePanel.setVerticalGroup(
			gl_CreatePanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_CreatePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreate)
					.addGap(26)
					.addGroup(gl_CreatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudent1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbStudent1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_CreatePanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStudent2, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbStudent2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_CreatePanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfSubmit, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfDateOfSubmit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(btnAdd)
					.addContainerGap())
		);
		CreatePanel.setLayout(gl_CreatePanel);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textPane.setText(project.toString());
		textPane.setEditable(false);
		textPane.setCaret(null);
		textPane.setBackground(new Color(240, 240, 240));
		GroupLayout gl_InfoPanel = new GroupLayout(InfoPanel);
		gl_InfoPanel.setHorizontalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_InfoPanel.setVerticalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					.addContainerGap())
		);
		InfoPanel.setLayout(gl_InfoPanel);
		contentPane_1.setLayout(gl_contentPane_1);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////action Listeners
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		btnDateOfSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Get the selected row index from the JTable
		        int selectedRowIndex = teamsTable.getSelectedRow();

		        if (selectedRowIndex != -1) { // Check if a row is selected
		            // Get the team at the selected row
		            Team selectedTeam = teams.get(selectedRowIndex);

		            // Show an input dialog to get the new date from the user
		            String newDate = JOptionPane.showInputDialog(
		                    null,
		                    "Enter the new date of submission (YYYY-MM-DD):",
		                    "Enter Date",
		                    JOptionPane.PLAIN_MESSAGE
		            );

		            if (Objects.isNull(newDate) || newDate.isBlank() ) {
		            	// User canceled or entered an empty date
		                JOptionPane.showMessageDialog(null, "Date not updated.");
		                
		            } else {
		            	// Update the date in the selected Team object
		                selectedTeam.setDateOfSubmit(LocalDate.parse(newDate));

		                // Update the date in the JTable
		                teamsTable.getModel().setValueAt(newDate, selectedRowIndex, 2);

		                // Update the date in the database
		                teamDAO.update(selectedTeam);
						updateTeamsTable();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to update the date.");
		        }
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected row index from the JTable
		    	updateTeamsTable();
		        int selectedRowIndex = teamsTable.getSelectedRow();

		        if (selectedRowIndex != -1) { // Check if a row is selected
		            // Get the team at the selected row
		            Team selectedTeam = teams.get(selectedRowIndex);

		            int result = JOptionPane.showConfirmDialog(
		                null,
		                "Are you sure you want to delete the team : " + selectedTeam.getStudent1().getFullName() + " and " + selectedTeam.getStudent2().getFullName(),
		                "Confirmation",
		                JOptionPane.YES_NO_OPTION
		            );

		            if (result == JOptionPane.YES_OPTION) {
		                // User clicked "Yes", proceed with deletion
		                teamDAO.delete(selectedTeam);
						updateTeamsTable();

		                // Remove the selected row from the JTable
		                DefaultTableModel model = (DefaultTableModel) teamsTable.getModel();
		                model.removeRow(selectedRowIndex);
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
		        }
		    }
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> studentIDs = new ArrayList<>();
				for(Team team : teams) {
					studentIDs.add(team.getStudent1().getId());
					studentIDs.add(team.getStudent2().getId());
				}
				
				Integer student1ID = (Integer) cbStudent1.getSelectedItem();
				Integer student2ID = (Integer) cbStudent2.getSelectedItem();
				String date = tfDateOfSubmit.getText();
				
				if(student1ID.equals(0) || student2ID.equals(0)) {
					
					lblCreate.setForeground(Color.red);
					lblCreate.setText("please select a student");
					
				} else if(studentIDs.contains(student1ID)|| studentIDs.contains(student2ID)){
					
		        	JOptionPane.showMessageDialog(null, "Students already in teams.");
					
				}else {
					Student student1 = teamDAO.getStudent(student1ID);
					Student student2 = teamDAO.getStudent(student2ID);
					
					Team team = date.isBlank()? new Team(student1, student2, project.getIdProject()) 
							: new Team(student1, student2, project.getIdProject(), date);
					teamDAO.create(team);
					updateTeamsTable();
					
					 // Add the new row to the JTable
		            DefaultTableModel model = (DefaultTableModel) teamsTable.getModel();
		            model.addRow(new Object[]{student1.getFullName(), student2.getFullName(), date});

		            // scroll to the newly added row
		            int rowIndex = model.getRowCount() - 1;
		            teamsTable.scrollRectToVisible(teamsTable.getCellRect(rowIndex, 0, true));
				}

				}

			}
		);
		
		btnGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	updateTeamsTable();
		        int selectedRowIndex = teamsTable.getSelectedRow();
		        
		        if (selectedRowIndex != -1) { // Check if a row is selected
		            Team selectedTeam = teams.get(selectedRowIndex);

		        	dispose();
					GradeView gradePage = new GradeView(selectedTeam);
					gradePage.setVisible(true);
		        
		        }else {
		        	JOptionPane.showMessageDialog(null, "Please select a row to view.");
		        }

			}
		});
		
		
	}
	
	private void updateTeamsTable() {
		this.teams.clear();
		for (Team team : teamDAO.getAll()) {
			if(team.getIdProject() == project.getIdProject()) {
				this.teams.add(team);
		    }
		}
	}
}
