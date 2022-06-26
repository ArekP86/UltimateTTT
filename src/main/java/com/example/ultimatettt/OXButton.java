package com.example.ultimatettt;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class OXButton extends Button {
    Game.Field field;
    boolean empty = true;
    private Game.Turn value = Game.Turn.None;
    private final OXBoard oxBoard;
    public final int id;
    static private int lastId = 0;
    private boolean active = true;

    public OXButton(OXBoard oxBoard, Game.Field field) {
        System.out.println("OXButton CTOR");
        this.id = lastId++;
        this.oxBoard = oxBoard;
        this.field = field;

        setPrefSize(80,80);

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                {
                    if (empty && active) {
                        value = oxBoard.getCurrentMove();
                        if(value == Game.Turn.o) {
                            ImageView iv = new ImageView(new Image("O_70px.png"));
                            setGraphic(iv);
                        } else {
                            ImageView iv = new ImageView(new Image("X_70px.png"));
                            setGraphic(iv);
                        }
                        empty = false;
                        oxBoard.moveMade(field);
                    }
                }
            }
        });
    }

    public void setActive() {
        active = true;
    }

    public void setInactive() {
        active = false;
    }

    public Game.Turn getValue() {
        return value;
    }
}
