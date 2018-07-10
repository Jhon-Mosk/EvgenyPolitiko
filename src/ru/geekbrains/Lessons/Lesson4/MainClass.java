package Lesson_4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass {
    public static void main(String[] args) {
       new MyWindow();
    }
}

class MyWindow extends JFrame {
    public MyWindow() {
        setTitle("Java Chat");
        setBounds(800,300,400,400);

        ImageIcon icon = new ImageIcon("src/img/hashtag.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        centerPanel.setBackground(Color.black.gray);
        bottomPanel.setBackground(Color.black.green);

        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());

        JTextArea jta = new JTextArea();
        JScrollPane jsp = new JScrollPane(jta);
        centerPanel.add(jsp, BorderLayout.CENTER);

        JTextField jtf = new JTextField();
        JButton jb = new JButton("Send");

        bottomPanel.add(jtf);
        bottomPanel.add(jb);

        jtf.setPreferredSize(new Dimension(300,28));
        jta.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jta.append(jtf.getText() + "\n");
                jtf.setText("");
                jtf.grabFocus();
            }
        });

        jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                   // send();
                }

            }
        });

     //   System.exit(5);






        setVisible(true);
    }

//    static void send() {
//        jta.append(jtf.getText() + "\n");
//        jtf.setText("");
//        jtf.grabFocus();
//    }

}
