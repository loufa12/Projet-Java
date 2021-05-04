package com.company;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class Fenetre1 extends JFrame
{
    private static final long serialVersionUID = 1;

    final JTextArea text1;
    final JButton button;

    public Fenetre1()
    {
        text1 = new JTextArea("Texte");
        add(text1,BorderLayout.NORTH);

        button = new JButton("Bouton");
        add(button,BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Fenetre2 extends JFrame
{
    private static final long serialVersionUID = 1;

    final JTextArea text2;

    public Fenetre2(final Fenetre1 f1)
    {
        text2 = new JTextArea();
        add(text2);

        f1.button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                text2.setText(f1.text1.getText());
            }
        });

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class Test {
    public static void main(String[] args)
    {
        Fenetre1 f1 = new Fenetre1();
        Fenetre2 f2 = new Fenetre2(f1);
    }
}