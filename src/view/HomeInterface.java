package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeInterface extends JFrame {

    public HomeInterface() {
        setTitle("HomeInterface");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnProjects = new JButton("Projects");
        btnProjects.setBounds(50, 30, 100, 30);

        JButton btnStudents = new JButton("Students");
        btnStudents.setBounds(160, 30, 100, 30);

        add(btnProjects);
        add(btnStudents);

        btnProjects.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ajoutez le code pour la fonctionnalité des projets ici
            }
        });

        btnStudents.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StudentInterface().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
    	HomeInterface homeInterface = new HomeInterface();
    	homeInterface.setVisible(true);
    }
}
