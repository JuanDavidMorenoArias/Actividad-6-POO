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



public class UpdateFriend {
    public static void update(String oldName, String newName, String newNumber) {
        try {
            File file = new File(DeleteFriend.FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] contact = line.split(",");
                String name = contact[0];
                String number = contact[1];

                if (name.equalsIgnoreCase(oldName)) {
                    writer.write(newName + "," + newNumber + "\n");
                } else {
                    writer.write(name + "," + number + "\n");
                }
            }

            writer.close();
            reader.close();

            if (file.delete()) {
                if (tempFile.renameTo(file)) {
                    JOptionPane.showMessageDialog(null, "Contact updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to rename the temporary file.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update the contact.");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while updating the contact.");
            e.printStackTrace();
        }
    }
}