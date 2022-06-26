package com.example.ultimatettt;


import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class OXButton extends Button {
    Game.Field field;
    boolean empty = true;
    private Game.Turn value = Game.Turn.None;
    private final OXBoard oxBoard;
    public final int id;
    static private int lastId = 0;
    private boolean active = true;

    public OXButton(OXBoard oxBoard, Game.Field field) {
        this.id = lastId++;
        this.oxBoard = oxBoard;
        this.field = field;

        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                {
                    if (empty && active) {
                        Image image;
                        if(oxBoard.getCurrentMove() == Game.Turn.o) {
                            image = new Image("O_70px.png");
                        } else {
                            image = new Image("X_70px.png");
                        }
                        ImageView iv = new ImageView(image);
                        setGraphic(iv);

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
