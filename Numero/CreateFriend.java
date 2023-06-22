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


public class CreateFriend {
    public static void create(String name, String number) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(DeleteFriend.FILE_NAME, true));
            writer.write(name + "," + number + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "Contact created successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while creating the contact.");
            e.printStackTrace();
        }
    }
}
