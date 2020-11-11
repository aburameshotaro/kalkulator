package com.company;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Kalkulator extends JFrame{
    JFrame f;

    public static void addComponentsToPane(Container pane) {

        JButton button;
        JButton b_numerical;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JTextField tf=new JTextField("0");
        tf.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.ipady = 20;
        c.insets = new Insets(5,5,15,5);
        c.gridy = 0;
        c.gridwidth = 5;
        pane.add(tf, c);

        button = new JButton("%");
        c.gridwidth = 1;
        c.ipady = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,5,5,5);
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("/");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("x");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 2;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 3;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("C");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        c.gridy = 1;
        pane.add(button, c);

        button = new JButton("AC");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("(");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        c.gridy = 3;
        pane.add(button, c);

        button = new JButton(")");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        c.gridy = 4;
        pane.add(button, c);

        button = new JButton("+/-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,10,5,5);
        c.gridx = 4;
        c.gridy = 5;
        pane.add(button, c);

        button = new JButton("+");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 3;
        c.gridheight = 2;
        c.gridy = 2;
        pane.add(button, c);

        button = new JButton("=");
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 3;
        c.gridheight = 2;
        c.gridy = 4;
        pane.add(button, c);

        b_numerical = new JButton("7");
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.insets = new Insets(5,5,5,5);
        c.gridy = 2;
        pane.add(b_numerical, c);

        b_numerical = new JButton("8");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 1;
        c.gridy = 2;
        pane.add(b_numerical, c);

        b_numerical = new JButton("9");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 2;
        c.gridy = 2;
        pane.add(b_numerical, c);

        b_numerical = new JButton("4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 3;
        pane.add(b_numerical, c);

        b_numerical = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 1;
        c.gridy = 3;
        pane.add(b_numerical, c);

        b_numerical = new JButton("6");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 2;
        c.gridy = 3;
        pane.add(b_numerical, c);

        b_numerical = new JButton("1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;
        c.gridy = 4;
        pane.add(b_numerical, c);

        b_numerical = new JButton("2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 1;
        c.gridy = 4;
        pane.add(b_numerical, c);

        b_numerical = new JButton("3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 2;
        c.gridy = 4;
        pane.add(b_numerical, c);

        b_numerical = new JButton("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 5;
        pane.add(b_numerical, c);

        button = new JButton(",");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 1;   //2 columns wide
        c.gridy = 5;
        pane.add(button, c);

        b_numerical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Write your action here

            }
        });

    }


    Kalkulator(){
        f=new JFrame();
        addComponentsToPane(f.getContentPane());


        f.setSize(300,300);//400 width and 500 height
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
