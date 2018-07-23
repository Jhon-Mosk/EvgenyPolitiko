package ru.geekbrains.Dz.Dz6.fromLesson.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    Socket socket = null;
    ServerMain serverMain = null;
    DataInputStream in;
    DataOutputStream out;

    public ClientHandler(ServerMain serverMain, Socket socket){

        try {
            this.socket = socket;
            this.serverMain = serverMain;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")){
                            out.writeUTF("/serverClosed");
                            break;
                        }
                        serverMain.broadCastMsg(str);

                    }}
                    catch (IOException e){
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

                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg (String msg){
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
