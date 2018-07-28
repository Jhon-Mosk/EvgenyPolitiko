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
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientList();
    }

    public void broadCastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients
                ) {
            if (!o.checkBlackList(from.getName())){

                    o.sendMsg(msg);


            }

        }
    }

    public void privateMsg (ClientHandler from, String msg) {


        String [] privat = msg.split(" ", 3);

        for (ClientHandler o : clients){
            if (o.getName().equals(privat [1])){
                o.sendMsg("Private message from " + from.getName() + ": " + privat[2]);
                from.sendMsg("Private message to " + privat[1] + ": " + privat[2]);
                return;
            }
        }

        from.sendMsg(privat[1] + " is absent");

    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) return true;
        }
        return false;

    }

    public void broadcastClientList (){
        StringBuilder sb = new StringBuilder();
        sb.append("/clientList ");
        for (ClientHandler o : clients){
            sb.append(o.getName() + " ");
        }
        String out = sb.toString();
        for (ClientHandler o: clients) {
            o.sendMsg(out);
        }
    }

}