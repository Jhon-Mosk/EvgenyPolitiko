package ru.geekbrains.Dz.Dz7.client;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    StackPane pane;

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    Button btn;

    @FXML
    Button musicBtn;

    @FXML
    HBox upperPanel;

    @FXML
    HBox bottomPanel;

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    ListView clientList;

    @FXML
    HBox privateMsgWindow;

    @FXML
    TextField nickField;

    @FXML
    TextField msgField;

    @FXML
    TextField nicknameField;


    private boolean isAuthorized;

    private String soundtrack = getClass().getResource("sdt.mp3").toString();
    private Media sound = new Media(soundtrack);
    private MediaPlayer mediaPlayer = new MediaPlayer(sound);

    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void connect() {
        try {
            socket = new Socket(IP_ADRESS, PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            String[] col = {"black", "red", "green", "gray", "magenta", "orange", "cyan", "gold"};
            Random rand = new Random();

            setAuthorized(false);

            Thread t1 = new Thread(() -> {
                try {

                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/authentication success")) {
                            setAuthorized(true);
                            break;
                        } else {

                            textArea.appendText(str + "\n");
                        }
                    }

                    getHistory();

                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/serverClosed"))
                            break;
                        if (str.startsWith("/clientList")) {
                            String[] tokens = str.split(" ");
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    clientList.getItems().clear();
                                    for (int i = 1; i < tokens.length; i++) {
                                        clientList.getItems().add(tokens[i]);
                                    }
                                }
                            });

                        } else {
                            int color = rand.nextInt(col.length);
                            textArea.setStyle("-fx-text-fill:" + col[color] + ";");
                            textArea.appendText(str + "\n");
                        }
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
                setAuthorized(false);
            }
            );

            t1.setDaemon(true);
            t1.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getHistory() {
        try {
            out.writeUTF("/history ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
        if (!isAuthorized) {
            upperPanel.setVisible(true);
            upperPanel.setManaged(true);
            bottomPanel.setVisible(false);
            bottomPanel.setManaged(false);
            clientList.setManaged(false);
            clientList.setVisible(false);
        } else {
            upperPanel.setVisible(false);
            upperPanel.setManaged(false);
            bottomPanel.setVisible(true);
            bottomPanel.setManaged(true);
            clientList.setManaged(true);
            clientList.setVisible(true);
        }
    }

    public void sendMsg() {
        try {
            out.writeUTF(textField.getText());
            textField.clear();
            textField.requestFocus();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void btnColor() {
        btn.setTextFill(Paint.valueOf("red"));
    }

    public void btnColorDft() {
        btn.setTextFill(Paint.valueOf("gold"));
    }

    private void music() {
        mediaPlayer.play();
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    }

    public void musicOnOff() {
        if (musicBtn.getText().equals("Музыка: off")) {
            musicBtn.setText("Музыка: on");
            musicBtn.setTextFill(Paint.valueOf("red"));
            music();
        } else {
            musicBtn.setText("Музыка: off");
            mediaPlayer.stop();
            musicBtn.setTextFill(Paint.valueOf("gold"));
        }
    }

    public void tryToAuth(ActionEvent actionEvent) {
        if (socket == null || socket.isClosed()) {
            connect();
        }
        try {
            out.writeUTF("/auth " + loginField.getText() + " " + passwordField.getText());
            loginField.clear();
            passwordField.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void priv(MouseEvent mouseEvent) {

        bottomPanel.setVisible(false);
        bottomPanel.setManaged(false);
        clientList.setManaged(true);
        clientList.setVisible(true);
        privateMsgWindow.setManaged(true);
        privateMsgWindow.setVisible(true);

    }

    public void sendPrivMsg(ActionEvent actionEvent) {
        String nick = nickField.getText();
        String privMsg = msgField.getText();

        try {
            out.writeUTF("/w " + nick + " " + privMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }

        msgField.clear();
        msgField.requestFocus();


    }

    public void comeSharedChat(ActionEvent actionEvent) {
        bottomPanel.setVisible(true);
        bottomPanel.setManaged(true);
        clientList.setManaged(true);
        clientList.setVisible(true);
        privateMsgWindow.setManaged(false);
        privateMsgWindow.setVisible(false);
    }

    public void register(ActionEvent actionEvent) {
Register reg = new Register(out);
reg.show();

    }


}
