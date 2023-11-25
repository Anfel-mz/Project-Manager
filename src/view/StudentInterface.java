/*package view;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import database.ProgramDAO;
import model.Program;

public class StudentInterface extends JFrame {

    private JList<Program> programList;
    private ProgramDAO programDAO;
    
    
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


    public StudentInterface() {
        setTitle("Student Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        programDAO = new ProgramDAO();
        programList = new JList<>(programDAO.getAll().toArray(new Program[0]));

        JScrollPane scrollPane = new JScrollPane(programList);
        scrollPane.setBounds(20, 20, 250, 120);

        add(scrollPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ajoutez le code pour les actions à effectuer lors de la fermeture de cette interface
            }
        });
    }
}*/
package view;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import database.ProgramDAO;
import model.Program;

public class StudentInterface extends JFrame {

    private JList<String> programList;
    private ProgramDAO programDAO;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StudentInterface frame = new StudentInterface();
                    frame.updateProgramList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public StudentInterface() {
        setTitle("Student Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        programDAO = new ProgramDAO();
        programList = new JList<>();

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("ID\tName\tPromo"); // Ajoutez l'en-tête
        programList.setModel(model);

        JScrollPane scrollPane = new JScrollPane(programList);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        contentPane.add(scrollPane);

        setContentPane(contentPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // Ajoutez le code pour les actions à effectuer lors de la fermeture de cette interface
            }
        });
    }

    // Mettez à jour la liste avec les titres des colonnes
    public void updateProgramList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("ID\tName\tPromo"); // Ajoutez l'en-tête

        List<Program> programs = programDAO.getAll();

        for (Program program : programs) {
            model.addElement(program.getIdProgram() + "\t" + program.getName() + "\t" + program.getPromo());
        }

        programList.setModel(model);
        programList.repaint(); // Assurez-vous que la liste est redessinée après la mise à jour
    }
}
