package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import database.*;
import model.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GradeView extends JFrame {
	private JPanel contentPane;
	private JPanel contentPane_1;
	private JTextField tfGradeEssay;
	private Grade grade;
	private JTextField tfPresentation1;
	private JTextField tfPresentation2;

	public GradeView(Team team) {
		GradeDAO gradeDAO = new GradeDAO();
		
		this.grade = gradeDAO.getGrade(team.getStudent1().getId(), team.getStudent2().getId(), team.getIdProject());
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectView.class.getResource("/util/resources/iconn.png")));
		setTitle("Grade");
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
		
		JPanel panelCreate = new JPanel();
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, 506, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(InfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblTitle = new JLabel("Grade : ");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblEssay = new JLabel("Essay : ");
		lblEssay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblPresentation = new JLabel("Presentation :");
		lblPresentation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		tfGradeEssay = new JTextField();
		tfGradeEssay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfGradeEssay.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblStud1 = new JLabel("Student 1 :");
		lblStud1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblStud2 = new JLabel("Student 2 :");
		lblStud2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tfPresentation1 = new JTextField();
		tfPresentation1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPresentation1.setColumns(10);
		
		tfPresentation2 = new JTextField();
		tfPresentation2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPresentation2.setColumns(10);
		
		JLabel lblFinalGrade = new JLabel("Final grade : ");
		lblFinalGrade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblStudent1 = new JLabel("Student 1 :");
		lblStudent1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblStudent2 = new JLabel("Student 2 :");
		lblStudent2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblFinal1 = new JLabel("");
		lblFinal1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblFinal2 = new JLabel("");
		lblFinal2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeamView teamView = new TeamView(gradeDAO.getProject(team.getIdProject()));
				dispose();
				teamView.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panelCreate = new GroupLayout(panelCreate);
		gl_panelCreate.setHorizontalGroup(
			gl_panelCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFinalGrade, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPresentation)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addComponent(lblEssay)
							.addGap(79)
							.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
								.addComponent(tfPresentation1, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfGradeEssay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPresentation2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(212, Short.MAX_VALUE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addContainerGap(457, Short.MAX_VALUE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblStud2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStud1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(416, Short.MAX_VALUE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelCreate.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED, 295, Short.MAX_VALUE)
							.addComponent(btnAdd)
							.addGap(56))
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
								.addComponent(lblStudent1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudent2, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
							.addGap(46)
							.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCreate.createSequentialGroup()
									.addComponent(lblFinal1, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
									.addGap(212))
								.addGroup(gl_panelCreate.createSequentialGroup()
									.addComponent(lblFinal2, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
									.addContainerGap(212, Short.MAX_VALUE))))))
		);
		gl_panelCreate.setVerticalGroup(
			gl_panelCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addGap(65)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEssay)
						.addComponent(tfGradeEssay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addComponent(lblPresentation)
							.addGap(28)
							.addComponent(lblStud1))
						.addComponent(tfPresentation1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStud2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfPresentation2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addComponent(lblFinalGrade, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblFinal1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblStudent1, GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
					.addGap(27)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addComponent(lblStudent2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addGroup(gl_panelCreate.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAdd)
								.addComponent(btnNewButton)))
						.addComponent(lblFinal2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panelCreate.setLayout(gl_panelCreate);

		
		JTextPane tpTeam = new JTextPane();
		tpTeam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tpTeam.setEditable(false);
		tpTeam.setCaret(null);
		tpTeam.setBackground(new Color(240, 240, 240));
		tpTeam.setText(team.toString());
		
		JTextPane tpGrade = new JTextPane();
		tpGrade.setText(grade.toString());
		tpGrade.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tpGrade.setEditable(false);
		tpGrade.setBackground(SystemColor.menu);
		GroupLayout gl_InfoPanel = new GroupLayout(InfoPanel);
		gl_InfoPanel.setHorizontalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_InfoPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(tpGrade, GroupLayout.PREFERRED_SIZE, 486, GroupLayout.PREFERRED_SIZE)
						.addComponent(tpTeam, GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_InfoPanel.setVerticalGroup(
			gl_InfoPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InfoPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(tpTeam, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tpGrade, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		InfoPanel.setLayout(gl_InfoPanel);
		contentPane_1.setLayout(gl_contentPane_1);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(tfGradeEssay.getText().isBlank() && tfPresentation1.getText().isBlank() && tfPresentation2.getText().isBlank()) {
					
				    JOptionPane.showMessageDialog(null, "Please provide either a grade for Essay or Presentation.", 
				    		"Input Error", JOptionPane.WARNING_MESSAGE);
					
				}else {
					float gradeEssay = tfGradeEssay.getText().isBlank()? grade.getGradeEssay() : Float.parseFloat(tfGradeEssay.getText());
					float gradePresentation1 = tfPresentation1.getText().isBlank()?grade.getGradePresentation1() : Float.parseFloat(tfPresentation1.getText());
					float gradePresentation2 = tfPresentation2.getText().isBlank()?grade.getGradePresentation2() : Float.parseFloat(tfPresentation2.getText());
					
					
					grade.setGradeEssay(gradeEssay);
					grade.setGradePresentation1(gradePresentation1);
					grade.setGradePresentation2(gradePresentation2);
					grade.setFinalGrade1(gradeDAO.getFinalGrade(grade)[0]);
					grade.setFinalGrade2(gradeDAO.getFinalGrade(grade)[1]);

					gradeDAO.update(grade);
					tpGrade.setText(grade.toString());
					lblFinal1.setText(String.valueOf(grade.getFinalGrade1()));
					lblFinal2.setText(String.valueOf(grade.getFinalGrade2()));
					
				}
				
				
				
			}
		});
		
	}
}
