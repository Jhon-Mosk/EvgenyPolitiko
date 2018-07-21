package ru.geekbrains.Dz.Dz7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private Socket socket = null;
    private ServerMain serverMain = null;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;



    public ClientHandler(ServerMain serverMain, Socket socket) {

        try {
            this.socket = socket;
            this.serverMain = serverMain;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                if (!serverMain.isNickBusy(newNick)) {
                                    sendMsg("/authentication success");
                                    nick = newNick;
                                    serverMain.broadCastMsg(nick + " with us");
                                    sendMsg("Welcome to our chat");
                                    serverMain.subscribe(this);
                                    break;
                                } else sendMsg("This nick is busy. You sure that is your nick");

                            } else {
                                sendMsg("Login or password is wrong. Try again.");
                            }
                        }
                    }

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/serverClosed");
                            break;
                        }
                        if (str.startsWith("/w")){

                            serverMain.privateMsg(str);
                        } else {

                        serverMain.broadCastMsg(nick + ": " + str);
                        System.out.println("Client: " + str);}
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                serverMain.unsubscribe(ClientHandler.this);

            }
            ).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName(){
        return nick;
    }

}
