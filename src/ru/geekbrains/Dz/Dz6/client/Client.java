package ru.geekbrains.Dz.Dz6.client;

import sun.awt.windows.ThemeReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {


        final String SERVER_ADDR = "localhost";
        final int SERVER_PORT = 8189;
        Socket socket = null;
        DataInputStream in;
        DataOutputStream out;


        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);


            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {


                    try {
                        while (true) {
                            String w = in.readUTF();
                            if (w.equalsIgnoreCase("/end")) {

                                out.writeUTF("/end");
                                sc.close();
                                System.out.println("Bye");
                                break;
                            }
                            System.out.println("Server:" + w);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });



            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        while(true){
                        out.writeUTF(sc.nextLine());
                        out.flush();}
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });
            t1.start();
            t2.setDaemon(true);
            t2.start();

            try {
                t1.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}  