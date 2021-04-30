package inter;

import jdk.internal.cmm.SystemResourcePressureImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Début...");

        JFrame window = new JFrame("Première Fenêtre Java Swing");
        window.setSize(new Dimension(1000, 700));

        //JPanel
        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        window.add(panel1);

        //JLabel (pour la première colonne)
        //JLabel label1 = new JLabel("Premier label");
        //panel1.add(label1);
        //label1.setPreferredSize(new Dimension(80,100));
        //label1.setIcon(new ImageIcon(lien image à afficher));

        //Button
        JButton button1 = new JButton("Bouton de Test");
        panel1.add(button1);

        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        System.out.println("...Fin");

    }
}
