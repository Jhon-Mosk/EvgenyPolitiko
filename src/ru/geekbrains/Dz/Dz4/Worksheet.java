package ru.geekbrains.Dz.Dz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*Создать окно с тремя полями и кнопкой (поля не активные)
при нажатии на копку появляется новое окно куда можно внести ФИО нажимаем кнопку ОК и окно скрывается
данные переходят в наше первое окно.*/

public class Worksheet {
    public static void main(String[] args) {
new Form();
    }
}

class Form extends JFrame{
    public Form(){
setTitle("First Form");
setBounds(800, 300,400,400);
setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        JPanel surnameField = new JPanel();
        JPanel nameField = new JPanel();
        JPanel patronymicField = new JPanel();
        JPanel buttonPanel = new JPanel();

        surnameField.setBackground(Color.gray.darker());
        nameField.setBackground(Color.gray.darker());
        patronymicField.setBackground(Color.gray.darker());
//        buttonPanel.setBackground(Color.magenta);

        Font font = new Font("Verdana", Font.BOLD, 15);

        JLabel jLabSurname = new JLabel("  Surname");
        jLabSurname.setFont(font);

        JLabel jLabname = new JLabel("  Name");
        jLabname.setFont(font);

        JLabel jLabPatronymic = new JLabel("  Patronymic");
        jLabPatronymic.setFont(font);

        setLayout(new GridLayout(7,1));
        add(jLabSurname);
add(surnameField);
        add(jLabname);
add(nameField);
        add(jLabPatronymic);
add(patronymicField);
//        add(new JPanel());
add(buttonPanel);



        JTextField surname = new JTextField();
        JTextField name = new JTextField();
        JTextField patronymic = new JTextField();
        JButton jb = new JButton("OK");

        surnameField.add(surname);
nameField.add(name);
patronymicField.add(patronymic);
buttonPanel.add(jb);

surname.setPreferredSize(new Dimension(300,30));
        name.setPreferredSize(new Dimension(300,30));
        patronymic.setPreferredSize(new Dimension(300,30));



        surname.setEditable(false);
        name.setEditable(false);
        patronymic.setEditable(false);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Form2();
            }
        });

setVisible(true);
    }


}

class Form2 extends JFrame {
    public Form2(){


        setTitle("Second Form");
        setBounds(800, 300,400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel surnameField = new JPanel();
        JPanel nameField = new JPanel();
        JPanel patronymicField = new JPanel();
        JPanel buttonPanel = new JPanel();


        surnameField.setBackground(Color.gray.darker());
        nameField.setBackground(Color.gray.darker());
        patronymicField.setBackground(Color.gray.darker());
//        buttonPanel.setBackground(Color.magenta);

        Font font = new Font("Verdana", Font.BOLD, 15);

        JLabel jLabSurname = new JLabel("  Surname");
        jLabSurname.setFont(font);

        JLabel jLabname = new JLabel("  Name");
        jLabname.setFont(font);

        JLabel jLabPatronymic = new JLabel("  Patronymic");
        jLabPatronymic.setFont(font);

        setLayout(new GridLayout(8,1));
        add(new JLabel("    Print your data"));
        add(jLabSurname);
        add(surnameField);
        add(jLabname);
        add(nameField);
        add(jLabPatronymic);
        add(patronymicField);
//        add(new JPanel());
        add(buttonPanel);



        JTextField surname = new JTextField();
        JTextField name = new JTextField();
        JTextField patronymic = new JTextField();
        JButton jb = new JButton("OK");

        surnameField.add(surname);
        nameField.add(name);
        patronymicField.add(patronymic);
        buttonPanel.add(jb);

        surname.setPreferredSize(new Dimension(300,30));
        name.setPreferredSize(new Dimension(300,30));
        patronymic.setPreferredSize(new Dimension(300,30));





        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);

    }
}
