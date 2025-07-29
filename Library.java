import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Library {
     ArrayList<Book> books = new ArrayList<>();
     String filePath = "books.txt";

     public Library() {
        loadBooksFromFile();
    }

    public void addBookGUI() {
        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID:"));
            String title = JOptionPane.showInputDialog("Enter Title:");
            String author = JOptionPane.showInputDialog("Enter Author:");
            books.add(new Book(id, title, author));
            saveBooksToFile();
            JOptionPane.showMessageDialog(null, "Book added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid input!");
        }
    }

    public void viewBooksGUI() {
        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No books found.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append("ID: ").append(b.id)
              .append(", Title: ").append(b.title)
              .append(", Author: ").append(b.author)
              .append(", Issued: ").append(b.isIssued)
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void issueBookGUI() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to issue:"));
        for (Book b : books) {
            if (b.id == id) {
                if (!b.isIssued) {
                    b.isIssued = true;
                    saveBooksToFile();
                    JOptionPane.showMessageDialog(null, "Book issued.");
                } else {
                    JOptionPane.showMessageDialog(null, "Already issued.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
    }

    public void returnBookGUI() {
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to return:"));
        for (Book b : books) {
            if (b.id == id) {
                if (b.isIssued) {
                    b.isIssued = false;
                    saveBooksToFile();
                    JOptionPane.showMessageDialog(null, "Book returned.");
                } else {
                    JOptionPane.showMessageDialog(null, "Was not issued.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Book not found.");
    }

    public void loadBooksFromFile() {
    books.clear();  
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 4) {
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                boolean isIssued = Boolean.parseBoolean(parts[3]);

                Book book = new Book(id, title, author);
                book.isIssued = isIssued;
                books.add(book);
            }
        }
    } catch (IOException e) {
        System.out.println("No saved books found.");
    }
}

public void saveBooksToFile() {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
        for (Book b : books) {
            writer.write(b.id + "," + b.title + "," + b.author + "," + b.isIssued);
            writer.newLine();  
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error saving books.");
    }
}

    
}
