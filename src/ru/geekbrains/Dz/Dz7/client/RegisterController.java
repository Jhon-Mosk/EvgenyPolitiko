package ru.geekbrains.Dz.Dz7.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class RegisterController {

    @FXML
    TextField loginField;

    @FXML
    TextField passwordField;

    @FXML
    TextField nicknameField;

    @FXML
    Button registerButton;

    @FXML
    HBox registrationWindow;

    Socket socket;
    final String IP_ADRESS = "localhost";
    final int PORT = 8189;

    public void register(ActionEvent actionEvent) {


        try {
            socket = new Socket(IP_ADRESS, PORT);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("/register " + loginField.getText() + " " + passwordField.getText() + " " +
                    nicknameField.getText());
            loginField.clear();
            passwordField.clear();
            nicknameField.clear();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
