package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import database.ProjectDAO;
import database.TeamDAO;
import model.Project;
import model.Team;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ProjectView extends JFrame {

	private JPanel contentPane;
	private JTextField tfCourse;
	private JTextField tfDeadline;
    private DefaultListModel<String> listModel;
    @SuppressWarnings("rawtypes")
	private JList listOfProjects;


	
	/**
	 * Create the frame.
	 */
	public ProjectView() {
		ProjectDAO projectDAO = new ProjectDAO();
		TeamDAO teamDAO = new TeamDAO();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectView.class.getResource("/util/resources/iconn.png")));
		setTitle("Projects");
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
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panelShowList = new JPanel();
		
		JPanel panelCreate = new JPanel();
		
		JLabel lblTitle = new JLabel("Projects");
		lblTitle.setForeground(new Color(51, 102, 204));
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelShowList, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(432)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(533))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
						.addComponent(panelShowList, GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblCreate = new JLabel("enter information to create project");
		lblCreate.setBounds(87, 0, 266, 31);
		lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JTextPane tfSubject = new JTextPane();
		tfSubject.setBounds(96, 229, 358, 116);
		tfSubject.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSubject = new JLabel("Subject :");
		lblSubject.setBounds(10, 229, 68, 31);
		lblSubject.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(333, 463, 104, 34);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String course = tfCourse.getText();
				String deadline = tfDeadline.getText();
				String subject = tfSubject.getText();
				
				if(course.isBlank() || deadline.isBlank() || subject.isBlank()) {
					lblCreate.setForeground(Color.red);
					lblCreate.setText("Some information is missing !");
				}else {
				
				Project project = new Project(course, subject, LocalDate.parse(deadline));
				
				projectDAO.create(project);
				listModel.addElement(project.getSubject());
				}

			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblDeadline = new JLabel("Deadline :");
		lblDeadline.setBounds(10, 144, 79, 31);
		lblDeadline.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(10, 85, 68, 31);
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		tfCourse = new JTextField();
		tfCourse.setBounds(119, 84, 335, 33);
		tfCourse.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfCourse.setColumns(10);
		
		tfDeadline = new JTextField();
		tfDeadline.setBounds(119, 143, 335, 33);
		tfDeadline.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tfDeadline.setColumns(10);
		panelCreate.setLayout(null);
		panelCreate.add(lblCreate);
		panelCreate.add(lblSubject);
		panelCreate.add(tfSubject);
		panelCreate.add(btnAdd);
		panelCreate.add(lblCourse);
		panelCreate.add(lblDeadline);
		panelCreate.add(tfDeadline);
		panelCreate.add(tfCourse);
		
		JLabel lblNewLabel = new JLabel("(YYYY-MM-DD)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 175, 111, 14);
		panelCreate.add(lblNewLabel);
		
		JLabel lblProjectList = new JLabel("Projects list");
		lblProjectList.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listOfProjects.getSelectedIndex();
				if (selectedIndex != -1) {
		        	Project selectedProject = projectDAO.getAll().get(selectedIndex);

					dispose();
					TeamView teamPage = new TeamView(selectedProject);
					teamPage.setVisible(true);
				}else {
		            JOptionPane.showMessageDialog(null, "Please select a Project");
		        }
				
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listOfProjects.getSelectedIndex();

		        if (selectedIndex != -1) { // Check if an item is selected
		            // Remove the selected item from the DefaultListModel
		        	Project selectedProject = projectDAO.getAll().get(selectedIndex);
		        	
		        	int result = JOptionPane.showConfirmDialog(
		        		    null,
		        		    "Are you sure you want to delete: " + selectedProject,
		        		    "Confirmation",
		        		    JOptionPane.YES_NO_OPTION
		        		);

		        		if (result == JOptionPane.YES_OPTION) {
		        		    // User clicked "Yes", proceed with deletion
		        			for (Team team : teamDAO.getAll()) {
		        				if(team.getIdProject() == selectedProject.getIdProject()) {
		        					teamDAO.delete(team);
		        				}
		        			}
		        		    projectDAO.delete(selectedProject);
				            listModel.remove(selectedIndex);
		        		}
		           
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a Project to delete.");
		        }
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panelShowList = new GroupLayout(panelShowList);
		gl_panelShowList.setHorizontalGroup(
			gl_panelShowList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowList.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelShowList.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
						.addComponent(lblProjectList, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
				.addGroup(gl_panelShowList.createSequentialGroup()
					.addGap(75)
					.addComponent(btnView, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(211)
					.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addGap(88))
		);
		gl_panelShowList.setVerticalGroup(
			gl_panelShowList.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelShowList.createSequentialGroup()
					.addComponent(lblProjectList, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelShowList.createParallelGroup(Alignment.LEADING)
						.addComponent(btnView, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		//////////////////////////////////////////////////////////////
		///// Afficher les element en JList
		///////////////////////////////////////////////////////////////
		
		listModel = new DefaultListModel<>();
		

        // Populate the listModel with project names
        for (Project project : projectDAO.getAll()) {
            listModel.addElement(project.getSubject());
        }
        
		listOfProjects = new JList<>(listModel);

		listOfProjects.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
        
		scrollPane.setViewportView(listOfProjects);
		panelShowList.setLayout(gl_panelShowList);
		contentPane.setLayout(gl_contentPane);
	}
}
