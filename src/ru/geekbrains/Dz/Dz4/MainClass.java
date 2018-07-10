package ru.geekbrains.Dz.Dz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass {
    public static void main(String[] args) {
MyWindow();
    }
}

class MyWindow extends JFrame{
    public MyWindow(){
        setTitle("Java Chat");
        setBounds(800,300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/img/app.png");
        setIconImage(icon.getImage());

JPanel centerPanel = new JPanel();
JPanel buttonPanel = new JPanel();



centerPanel.setBackground(Color.gray);
buttonPanel.setBackground(Color.green.darker());

add(centerPanel, BorderLayout.CENTER);
add(buttonPanel, BorderLayout.SOUTH);

centerPanel.setLayout(new BorderLayout());
buttonPanel.setLayout(new FlowLayout());

JTextArea jta = new JTextArea();
JScrollPane jsp = new JScrollPane(jta);
centerPanel.add(jsp, BorderLayout.CENTER);
jta.setForeground(Color.blue);
JTextField jtf = new JTextField();
JButton jb = new JButton("Send");

buttonPanel.add(jtf);
buttonPanel.add(jb);

jtf.setPreferredSize(new Dimension(300, 28));
jta.setEditable(false);
jb.addActionListener(e ->
{ jta.append("You: ");
    jta.append(jtf.getText()+ "\n");
        jtf.setText("");
        jtf.grabFocus();}

);

jtf.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            jta.append("You: ");
            jta.append(jtf.getText()+"\n");
            jtf.setText("");
            jtf.grabFocus();
        }
    }
});


//        jtf.setText("What you say?");
        setVisible(true);
    }
}
