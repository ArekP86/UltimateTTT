package com.example.ultimatettt;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Optional;

public class UltimateTTT extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(UltimateTTT.class.getResource("game_v4.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        System.out.println("UltimateTTT CTOR");
        Group root = new Group();
        Game g = new Game();
        root.getChildren().add(g);
        Scene scene = new Scene(root, 1280, 720, Color.WHITE);
        stage.setTitle("Ultimate Tic Tac Toe by Lukasz P.");
        stage.setScene(scene);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Enough?");
        alert.setHeaderText("Exit?");
        alert.setContentText("Really want to cloase app?");

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    System.exit(0);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}