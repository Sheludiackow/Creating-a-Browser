package com.leshiy.java;

import javax.swing.*;

import java.awt.Container;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

// import java.awt.*;


public class Browser extends JFrame {
    private TextField field = new TextField();
    private JEditorPane display = new JEditorPane();
    private JScrollPane panee = new JScrollPane(display);

    public static void main(String args[]) {

        Browser file = new Browser();
        file.frameHandler();
    }

    public void frameHandler() {
        setTitle("Browser");
        setSize(1280, 880);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        addComponentsToFrame(getContentPane());

    }

    public void addComponentsToFrame(Container pane) {

        Insets insets = getInsets();

        pane.add(field);
        pane.add(panee);

        Font font = new Font("Menlo", Font.ITALIC, 12);

        field.setFont(font);

        field.setBounds(8 - insets.left, 30 - insets.top, 1268, 20);
        panee.setBounds(8 - insets.left, 52 - insets.top, 1268, 830);
        actionListenerCalls();

    }

    private void actionListenerCalls() {
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            loadData("http://" + e.getActionCommand());
            }
        });

    }
    private void loadData (String text){
        try {
            display.setPage(text);
        }catch (Exception e){
            System.out.println("nopenope");
        }

    }
}

