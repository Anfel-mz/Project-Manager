package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/util/resources/iconn.png")));
		setTitle("login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 650);
		setResizable(false);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 462, 653);
		contentPane.add(panel);
		
		JButton loginButton = new JButton("login");
		
		loginButton.setForeground(new Color(51, 102, 204));
		loginButton.setFont(new Font("Arial", Font.BOLD, 25));
		loginButton.setBackground(SystemColor.activeCaption);
		loginButton.setBounds(669, 503, 233, 78);
		contentPane.add(loginButton);

		
		usernameInput = new JTextField();
		usernameInput.setFont(new Font("Arial", Font.PLAIN, 25));
		usernameInput.setForeground(new Color(0, 0, 0));
		usernameInput.setBounds(669, 307, 368, 56);
		contentPane.add(usernameInput);
		usernameInput.setColumns(10);
		
		JLabel lblusername = new JLabel("Username : ");
		lblusername.setForeground(new Color(51, 102, 204));
		lblusername.setFont(new Font("Arial", Font.BOLD, 25));
		lblusername.setBounds(505, 311, 188, 49);
		contentPane.add(lblusername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(51, 102, 204));
		lblPassword.setFont(new Font("Arial", Font.BOLD, 25));
		lblPassword.setBounds(505, 399, 188, 49);
		contentPane.add(lblPassword);
		
		JLabel infoMessage = new JLabel("please enter your account information");
		infoMessage.setFont(new Font("Arial", Font.PLAIN, 20));
		infoMessage.setBounds(603, 146, 462, 78);
		contentPane.add(infoMessage);
		
		passwordInput = new JPasswordField();
		passwordInput.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordInput.setBounds(669, 399, 368, 56);
		contentPane.add(passwordInput);
		
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (passwordInput.getText().equals("admin") && usernameInput.getText().equals("admin")) {
					dispose();

					HomeView homeView = new HomeView();
			        homeView.setVisible(true);
			        
					
				} else {
					infoMessage.setText("username or password incorrect, please try again");
					infoMessage.setForeground(Color.red);
				}
			}
		});
		
		usernameInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordInput.requestFocusInWindow();
            }
        });
		
		passwordInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	loginButton.doClick();
            }
        });
	}
}
