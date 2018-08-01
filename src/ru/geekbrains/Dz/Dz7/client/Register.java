package ru.geekbrains.Dz.Dz7.client;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;


public class Register extends Stage {




    DataOutputStream out;




    public Register(DataOutputStream out) {
        this.out = out;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            setTitle("Registration");
            setScene(new Scene(root, 565, 15));
            setResizable(false);
//           show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
