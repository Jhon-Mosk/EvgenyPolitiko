package ru.geekbrains.Dz.Dz7.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("I like this chat");
        primaryStage.getIcons().add(new Image("css/Doom-3-icon.png"));
        StackPane sp = new StackPane();
        sp.setId("pane");

        Font.loadFont(Main.class.getResource("AmazDooMRight.ttf").toExternalForm(), 20);



        Scene scene = new Scene(root, 825, 675);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        scene.getStylesheets().add((getClass().getResource("/css/Style.css")).toExternalForm());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
