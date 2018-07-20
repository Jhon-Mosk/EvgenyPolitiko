package ru.geekbrains.Dz.Dz7.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
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

            while (true){
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

    public void subscribe (ClientHandler client){
clients.add(client);
    }

    public void unsubscribe (ClientHandler client){
        clients.remove(client);
    }

    public void broadCastMsg (String msg){
        for (ClientHandler o: clients
             ) {
            o.sendMsg(msg);
        }
    }

}
