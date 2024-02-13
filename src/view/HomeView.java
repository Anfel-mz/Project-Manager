package view;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Toolkit;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;

@SuppressWarnings("serial")
public class HomeView extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public HomeView() {
		setTitle("Home");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeView.class.getResource("/util/resources/iconn.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 650);
		setResizable(false);
        setLocationRelativeTo(null);
		
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
		
		JLabel lblmessage = new JLabel("Welcom to Project Manager");
		lblmessage.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(342, Short.MAX_VALUE)
					.addComponent(lblmessage, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
					.addGap(336))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addComponent(lblmessage, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(510, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
