package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;

import database.*;
import model.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentInfoView extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane_1;
    private JTable infoTable;
    private ArrayList<Team> teams = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
	private TeamDAO teamDAO = new TeamDAO();
	private GradeDAO gradeDAO = new GradeDAO();

	private Student student;

	/**
	 * Create the frame.
	 */
	public StudentInfoView(Student student) {
		this.student = student;
		updateTables();
		
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
		
		JPanel listPanel = new JPanel();
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(InfoPanel, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(listPanel, GroupLayout.PREFERRED_SIZE, 660, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(InfoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(listPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 549, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JLabel lblProjects = new JLabel("Projects :");
		lblProjects.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_listPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
						.addComponent(lblProjects, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblProjects, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		infoTable = new JTable();
		

		infoTable.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(infoTable);
		
		String[] columnNames = {"Project", "Team member",  "Essay", "Presentation", "final"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		for (Team team : teams) {
			for(Grade grade : grades) {
				if (student.getId() == grade.getStudent1().getId() && team.getStudent1().getId() == grade.getStudent1().getId()
						&& team.getStudent2().getId() == grade.getStudent2().getId() && team.getIdProject() == grade.getIdProject()) {
			
					Object[] rowData = { teamDAO.getProject(team.getIdProject()).getSubject(), team.getStudent2().getFullName(),
							grade.getGradeEssay(), grade.getGradePresentation1(), grade.getFinalGrade1()};
				    model.addRow(rowData);
				
				} else if (student.getId() == grade.getStudent2().getId() && team.getStudent1().getId() == grade.getStudent1().getId()
						&& team.getStudent2().getId() == grade.getStudent2().getId() && team.getIdProject() == grade.getIdProject()) {
					
					Object[] rowData = { teamDAO.getProject(team.getIdProject()).getSubject(), team.getStudent1().getFullName(),
							grade.getGradeEssay(), grade.getGradePresentation2(), grade.getFinalGrade2()};
				    model.addRow(rowData);
				}
			}  
		}
		
		infoTable.setModel(model);
		
		listPanel.setLayout(gl_listPanel);
		
		JTextPane tpStudentInfo = new JTextPane();
		tpStudentInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tpStudentInfo.setText(student.toString());
		tpStudentInfo.setEditable(false);
		tpStudentInfo.setCaret(null);
		tpStudentInfo.setBackground(new Color(240, 240, 240));
		
		JTextPane tpProgramInfo = new JTextPane();
		tpProgramInfo.setText(teamDAO.getProgram(student.getIdProgram()).toString());
		tpProgramInfo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tpProgramInfo.setEditable(false);
		tpProgramInfo.setBackground(SystemColor.menu);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentView studentView = new StudentView();
				dispose();
				studentView.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_InfoPanel = new GroupLayout(InfoPanel);
		gl_InfoPanel.setHorizontalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_InfoPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_InfoPanel.createSequentialGroup()
							.addGroup(gl_InfoPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(tpProgramInfo, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
								.addComponent(tpStudentInfo, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_InfoPanel.createSequentialGroup()
							.addComponent(btnNewButton)
							.addGap(20))))
		);
		gl_InfoPanel.setVerticalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tpStudentInfo, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tpProgramInfo, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(8))
		);
		InfoPanel.setLayout(gl_InfoPanel);
		contentPane_1.setLayout(gl_contentPane_1);
	}

	private void updateTables() {
	    this.teams.clear();
	    this.grades.clear();

	    
	    for (Team team : teamDAO.getAll()) {
	        
	        if (team.getStudent1().getId() == student.getId() || team.getStudent2().getId() == student.getId()) {
	            this.teams.add(team);
	        }
	    }

	    for (Grade grade : gradeDAO.getAll()) {
	        if (grade.getStudent1().getId() == student.getId() || grade.getStudent2().getId() == student.getId()) {
	            this.grades.add(grade);
	        }
	    }

	}

	
}
