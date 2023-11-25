package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.ProgramDAO;
import model.Program;

public class StudentView2 extends JFrame {

	private JPanel contentPane;
	private JTable programTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentView2 frame = new StudentView2();
					//////////
					frame.updateProgramList();
				    ////////
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
	public StudentView2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		
		programTable = new JTable();
        //programTable.setBounds(10, 56, 414, 194);
		
		///////
		contentPane.setLayout(new BorderLayout());
		///////
		
		
		
		
		///////
		// Adjust the size of the table
        programTable.setPreferredScrollableViewportSize(new Dimension(400, 150));

        // Add the table to a scroll pane for better visibility
        JScrollPane scrollPane = new JScrollPane(programTable);
        /////
        
        contentPane.add(scrollPane, BorderLayout.CENTER);  // Add to the CENTER
		
		
        //contentPane.add(programTable);
        
        
	}
	
	public void updateProgramList() {
		try {
        ProgramDAO programDAO = new ProgramDAO();
        ArrayList<Program> allPrograms = programDAO.getAll();
        
        /////
        System.out.println("Number of programs: " + allPrograms.size()); // Check the size
        ////

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Promotion");

        for (Program program : allPrograms) {
            model.addRow(new Object[]{program.getIdProgram(), program.getName(), program.getPromo().toString()});
        }

        programTable.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }

}
}
