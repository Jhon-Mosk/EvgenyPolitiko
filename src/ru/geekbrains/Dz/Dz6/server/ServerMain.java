package ru.geekbrains.Dz.Dz6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8189);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected");

//            Scanner in = new Scanner(socket.getInputStream());
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);


            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {


                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.equals("/end")) {
                                out.writeUTF("/end");
                                break;
                            }
                            System.out.println("User: " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            });

            t1.start();

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

            t2.setDaemon(true);
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
