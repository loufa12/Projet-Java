package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class Main {

    public static void main(String[] args) {

        JFrame Fenetre = new JFrame();
        Fenetre.setVisible(true);
        Fenetre.setSize(400,300);

        JPanel pannel = new JPanel();
        JLabel label = new JLabel("Saisisez le nombre de joueurs");
        JTextField  field = new JTextField ("Texte");

        JButton bouton = new JButton("Validation");
        FlowLayout flowlayout = new FlowLayout();

        field.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                System.out.println("test=" + field.getText());

            }
        });
        pannel.add(label);
        pannel.add(field);
        pannel.add(bouton);
        Fenetre.getContentPane().setLayout(flowlayout);
        Fenetre.getContentPane().add(bouton);
        Fenetre.getContentPane().add(pannel);
        Fenetre.setVisible(true);
    }
}
