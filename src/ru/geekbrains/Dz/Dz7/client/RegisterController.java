package ru.geekbrains.Dz.Dz7.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.DataOutputStream;
import java.io.IOException;


public class RegisterController {

    @FXML
    TextField loginField;

    @FXML
    TextField passwordField;

    @FXML
    TextField nicknameField;

    @FXML
    Button registerButton;

    public void register(ActionEvent actionEvent) {
        DataOutputStream out = ((Register)registerButton.getScene().getWindow()).out;
        try {
            out.writeUTF("/register" + loginField.getText() + " " + passwordField.getText() + " " +
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
