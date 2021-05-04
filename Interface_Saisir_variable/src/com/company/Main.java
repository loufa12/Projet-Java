package com.company;
        import javax.swing.* ;
        import java.awt.*;

// Objectif : afficher une fenêtre pour saisir une donnée qui sera stockée dans une variable
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Titre de la fenêtre");
        frame.setSize(800,800);
        frame.setVisible(true);

        JLabel jLabel = new JLabel ("indiquez le nombre de joueurs");
        jLabel.setPreferredSize(new Dimension(500, 500));
        // Les bordures montrent que le JLabel prend tout l’espace
        //jLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        frame.add(jLabel);

        JTextField textField = new JTextField();
        textField.setColumns(10); //On lui donne un nombre de colonnes à afficher
        frame.add(textField);
    }
}