package ru.geekbrains.Dz.Dz7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ServerMain {

    private Vector<ClientHandler> clients;

    public ServerMain() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();

            server = new ServerSocket(8189);
            System.out.println("Server start");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new ClientHandler(this, socket);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            AuthService.disconnect();

        }
    }


    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadCastMsg(String msg) {
        for (ClientHandler o : clients
                ) {
            o.sendMsg(msg);
        }
    }

    public void privateMsg (String msg) {


        String [] privat = msg.split(" ");
        ArrayList<String> mess = new ArrayList<>();

        for (int i = 2; i<privat.length; i++){
            mess.add(privat[i]);
        }

        for (ClientHandler o : clients){
            if (o.getName().equals(privat [1])){
                o.sendMsg("Private message from: " + privat[1] + " " + mess.toString());
            }
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) return true;
        }
        return false;

    }
}