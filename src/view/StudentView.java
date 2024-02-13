package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import database.ProgramDAO;
import database.StudentDAO;
import model.Program;
import model.Student;
import util.Sex;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class StudentView extends JFrame {

	private JPanel contentPane;
	private JTextField tfFullName;
	private JTextField tfDateOfBirth;
	private JTextField tfAdress;
	private JTextField tfEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JComboBox<String> cbProgram;
	@SuppressWarnings("rawtypes")
	private JList listStudents;



	/**
	 * Create the frame.
	 */
	public StudentView() {
		StudentDAO studentDAO = new StudentDAO();
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ProjectView.class.getResource("/util/resources/iconn.png")));
		setTitle("Students");
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
		
		JLabel lblTitle = new JLabel("Students");
		lblTitle.setForeground(new Color(51, 102, 204));
		lblTitle.setFont(new Font("Calibri", Font.BOLD, 35));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panelShowList, GroupLayout.PREFERRED_SIZE, 582, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(432)
							.addComponent(lblTitle)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelShowList, 0, 0, Short.MAX_VALUE)
						.addComponent(panelCreate, GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE))
					.addGap(23))
		);
		
		JLabel lblCreate = new JLabel("Please enter student profile");
		lblCreate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblSex = new JLabel("Sex :");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblFullName = new JLabel("Full Name :");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfFullName = new JTextField();
		tfFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfFullName.setColumns(10);
		
		JLabel lblAdress = new JLabel("Adress :");
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblProgram = new JLabel("Program :");
		lblProgram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		tfDateOfBirth = new JTextField();
		tfDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfDateOfBirth.setColumns(10);
		
		tfAdress = new JTextField();
		tfAdress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfAdress.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfEmail.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		cbProgram = new JComboBox<String>();

		ProgramDAO programDAO = new ProgramDAO();
        ArrayList<Program> programs = programDAO.getAll();
        programs.add(0, new Program("default"));
        for (Program program : programs) {
        		cbProgram.addItem(program.getName());
        }
        
        cbProgram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected program
                String selectedProgramName = (String) cbProgram.getSelectedItem();
                Program selectedProgram = null;
                for (Program program : programs) {
            		if(program.getName().equals(selectedProgramName)) {
            			selectedProgram = new Program(program.getIdProgram(), program.getName(), program.getPromo());
            		}
                }
                
                // Filter the list of students based on the selected program
                if (!"default".equals(selectedProgramName)) {
                	listModel.clear();
                	for (Student student : studentDAO.getAll()) {
                		if(student.getIdProgram() == selectedProgram.getIdProgram())
                			listModel.addElement(student.getFullName());
                    }
                }else {
                	listModel.clear();
                	for (Student student : studentDAO.getAll()) {
                		listModel.addElement(student.getFullName());
                	}
                
            }
        }});

		
		JLabel lblNewLabel = new JLabel("(YYYY-MM-DD)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panelCreate = new GroupLayout(panelCreate);
		gl_panelCreate.setHorizontalGroup(
			gl_panelCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(87)
					.addComponent(lblCreate))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(109)
							.addComponent(tfFullName, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateOfBirth)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(109)
							.addComponent(tfDateOfBirth, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSex)
					.addGap(78)
					.addComponent(rdbtnMale, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addComponent(rdbtnFemale, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(tfAdress, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(10)
					.addComponent(lblProgram, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(cbProgram, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addGap(343)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelCreate.setVerticalGroup(
			gl_panelCreate.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCreate.createSequentialGroup()
					.addComponent(lblCreate, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(tfFullName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(1)
							.addComponent(lblFullName, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(1)
							.addComponent(lblDateOfBirth, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfDateOfBirth, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(3)
							.addComponent(rdbtnMale))
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(3)
							.addComponent(rdbtnFemale)))
					.addGap(18)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(1)
							.addComponent(lblAdress, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfAdress, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(1)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelCreate.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCreate.createSequentialGroup()
							.addGap(1)
							.addComponent(lblProgram, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addComponent(cbProgram, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(93)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
		);
		panelCreate.setLayout(gl_panelCreate);
		
		JLabel lblStudentList = new JLabel("Students list");
		lblStudentList.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = listStudents.getSelectedIndex();

		        if (selectedIndex != -1) { // Check if an item is selected
		            // Remove the selected item from the DefaultListModel
					Student selectedStudent = studentDAO.getAll().get(selectedIndex);
					StudentInfoView studentinfoPage = new StudentInfoView(selectedStudent);
	        		studentinfoPage.setVisible(true);
	        		dispose();
		           
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a student. ");
		        }
				
			}
		});
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int selectedIndex = listStudents.getSelectedIndex();

				        if (selectedIndex != -1) { // Check if an item is selected
				            // Remove the selected item from the DefaultListModel
							Student selectedStudent = studentDAO.getAll().get(selectedIndex);

				        	int result = JOptionPane.showConfirmDialog(
				        		    null,
				        		    "Are you sure you want to delete: " + selectedStudent,
				        		    "Confirmation",
				        		    JOptionPane.YES_NO_OPTION
				        		);

				        		if (result == JOptionPane.YES_OPTION) {
				        		    // User clicked "Yes", proceed with deletion
				        		    studentDAO.delete(selectedStudent);
						            listModel.remove(selectedIndex);
				        		}
				           
				        } else {
				            JOptionPane.showMessageDialog(null, "Please select a student to delete.");
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
						.addComponent(lblStudentList, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
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
					.addComponent(lblStudentList, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelShowList.createParallelGroup(Alignment.LEADING)
						.addComponent(btnView, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fullName = tfFullName.getText();
				String dateOfBirth = tfDateOfBirth.getText();
				String address = tfAdress.getText();
				Sex sex = rdbtnMale.isSelected()?Sex.MALE:Sex.FEMALE;
				String email = tfEmail.getText();
				Program program =programs.get(cbProgram.getSelectedIndex());
				
				if(fullName.isBlank() || dateOfBirth.isBlank() || address.isBlank()|| email.isBlank() || !email.contains("@")
						|| (!rdbtnFemale.isSelected() && sex.equals(Sex.FEMALE)) || program.getName().equals("default")) {
					lblCreate.setForeground(Color.red);
					lblCreate.setText("Some information is missing or incorrect !");
				}else {
				
				Student student = new Student(fullName, LocalDate.parse(dateOfBirth), sex, address, email, program.getIdProgram());
				studentDAO.create(student);
	            listModel.addElement(student.getFullName());
				
				}

				
				
				}

			}
		);
		
		//////////////////////////////////////////////////////////////
		///// Afficher les element en JList
		///////////////////////////////////////////////////////////////
		
		

        // Populate the listModel with project names
        for (Student student : studentDAO.getAll()) {
            listModel.addElement(student.getFullName());
        }
        
        listStudents = new JList<>(listModel);
		listStudents.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		scrollPane.setViewportView(listStudents);
		panelShowList.setLayout(gl_panelShowList);
		contentPane.setLayout(gl_contentPane);
		
		
	}
}
