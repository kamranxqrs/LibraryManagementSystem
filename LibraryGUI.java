import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class LibraryGUI extends JFrame {
    Library library = new Library();

    public LibraryGUI() {
        setTitle("Library Management System");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 

        JLabel title = new JLabel("Library Management System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(new Color(33, 33, 33));


       JButton add = new JButton("Add Book");
        add.setFont(new Font("Arial", Font.BOLD, 16));
        add.setBackground(new Color(66, 135, 245));
        add.setForeground(Color.WHITE);
        add.setFocusPainted(false);
        add.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton view = new JButton("View Books");
        view.setFont(new Font("Arial", Font.BOLD, 16));
        view.setBackground(new Color(52, 168, 83));
        view.setForeground(Color.WHITE);
        view.setFocusPainted(false);
        view.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton issue = new JButton("Issue Book");
        issue.setFont(new Font("Arial", Font.BOLD, 16));
        issue.setBackground(new Color(255, 193, 7)); 
        issue.setForeground(Color.BLACK);
        issue.setFocusPainted(false);
        issue.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton returnB = new JButton("Return Book");
        returnB.setFont(new Font("Arial", Font.BOLD, 16));
        returnB.setBackground(new Color(103, 58, 183));
        returnB.setForeground(Color.WHITE);
        returnB.setFocusPainted(false);
        returnB.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 16));
        exit.setBackground(new Color(244, 67, 54));
        exit.setForeground(Color.WHITE);
        exit.setFocusPainted(false);
        exit.setCursor(new Cursor(Cursor.HAND_CURSOR));


        panel.add(add);
        panel.add(view);
        panel.add(issue);
        panel.add(returnB);
        panel.add(exit);
       
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);   
        add(panel, BorderLayout.CENTER);  


        add.addActionListener(e -> library.addBookGUI());
        view.addActionListener(e -> library.viewBooksGUI());
        issue.addActionListener(e -> library.issueBookGUI());
        returnB.addActionListener(e -> library.returnBookGUI());
        exit.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
    
}
