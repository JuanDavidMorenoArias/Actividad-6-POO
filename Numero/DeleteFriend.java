package Numero;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteFriend {
    public static final String FILE_NAME = "contacts.txt";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Friend Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter name:");
                String number = JOptionPane.showInputDialog(frame, "Enter number:");
                CreateFriend.create(name, number);
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReadFriend.read();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String oldName = JOptionPane.showInputDialog(frame, "Enter old name:");
                String newName = JOptionPane.showInputDialog(frame, "Enter new name:");
                String newNumber = JOptionPane.showInputDialog(frame, "Enter new number:");
                UpdateFriend.update(oldName, newName, newNumber);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter name to delete:");
                delete(name);
            }
        });

        panel.add(createButton);
        panel.add(readButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void delete(String name) {
        try {
            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = name;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.startsWith(lineToRemove))
                    continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (inputFile.delete()) {
                if (tempFile.renameTo(inputFile)) {
                    JOptionPane.showMessageDialog(null, "Contact deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to rename the temporary file.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete the contact.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while deleting the contact.");
            e.printStackTrace();
        }
    }
}