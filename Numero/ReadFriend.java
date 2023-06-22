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



public class ReadFriend {
    public static void read() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DeleteFriend.FILE_NAME));
            StringBuilder contacts = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] contact = line.split(",");
                String name = contact[0];
                String number = contact[1];
                contacts.append("Name: ").append(name).append(", Number: ").append(number).append("\n");
            }
            reader.close();
            JOptionPane.showMessageDialog(null, contacts.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the contacts.");
            e.printStackTrace();
        }
    }
}

