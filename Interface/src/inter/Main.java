package inter;

import jdk.internal.cmm.SystemResourcePressureImpl;
import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Début...");

        JFrame window = new JFrame("Première Fenêtre Java Swing");
        window.setSize(new Dimension(1200, 800));


        //JPanel
        JPanel panel1 = new JPanel(new GridLayout(1, 2));
        window.add(panel1);


        //JLabel
        JLabel label1 = new JLabel("Insérez le nombre de joueurs à droite ");
        panel1.add(label1);
        label1.setPreferredSize(new Dimension(100, 100));
        //label1.setIcon(new ImageIcon(lien image à afficher));


        //Texte à insérer

        Button button = new Button("saisir le nombre de joueurs");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getLabel().equals("saisir le nombre de joueurs")) {
                    button.setLabel("c'est saisi !");
                } else {
                    button.setLabel("saisir le nombre de joueurs");
                }
            }
        });

        frame.add(button);
        frame.setVisible(true);

    }

}
