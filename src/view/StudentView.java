package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import database.ProgramDAO;
import model.Program;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JList;

public class StudentView extends JFrame {
	


	private JPanel contentPane;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView frame = new StudentView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(30, 230, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Program");
		lblNewJgoodiesTitle.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewJgoodiesTitle.setBounds(30, 6, 122, 37);
		contentPane.add(lblNewJgoodiesTitle);
		
		//JList list = new JList<>();
		programList();
		list.setBounds(30, 184, 381, -119);
		contentPane.add(list);
		//programList();
		
		System.out.println(list);
		
		
		
	    }
		
		
		
		private void programList() {
	        ProgramDAO programDAO = new ProgramDAO();
	        ArrayList<Program> allPrograms = programDAO.getAll();

	        // Créez un tableau de noms de programmes pour remplir la JList
	        String[] programNames = new String[allPrograms.size()];
	        for (int i = 0; i < allPrograms.size(); i++) {
	            programNames[i] = allPrograms.get(i).getName();
	        }
	        
	        

	        // Remplissez la JList avec les noms de programmes
	        list.setListData(programNames);
	        
	    
	}
	

}
