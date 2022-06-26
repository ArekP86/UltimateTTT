package com.example.ultimatettt;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class OXBoard extends StackPane {

    private final ImageView valueImage = new ImageView();
    private final GridPane oxBoard = new GridPane();
    private final Game.Field field;
    private boolean resolved = false;
    private Game.Turn value = Game.Turn.None;
    private final UltimateBoard ultimateBoard;
    private final OXButton[][] oxButton = new OXButton[3][3];


    OXBoard(UltimateBoard ultimateBoard, Game.Field field) {
        this.ultimateBoard = ultimateBoard;
        this.field = field;
        int fieldInt = 0;
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                oxButton[x][y] = new OXButton(this, Game.Field.values()[fieldInt++]);
                GridPane.setConstraints(oxButton[x][y], x, y);
                oxBoard.getChildren().add(oxButton[x][y]);
            }
        }
        valueImage.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                valueImage.setVisible(false);
            }
        });

        valueImage.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                valueImage.setVisible(true);
            }
        });
        valueImage.setVisible(false);
    }

    public void setActive() {
        if (resolved) {
            return;
        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        oxButton[x][y].setOpacity(1);
                        oxButton[x][y].setActive();
                    }
                }
            }
        });
    }

    public void setInactive() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        oxButton[x][y].setOpacity(0.5);
                        oxButton[x][y].setInactive();
                    }
                }
            }
        });
    }

    public void moveMade(Game.Field field) {
        checkBoard();
        ultimateBoard.moveMade(this.field, field);
    }

    private void checkBoard() {
        for (int x = 0; x < 3; x++) {
            boolean rowO = true;
            boolean rowX = true;
            boolean colO = true;
            boolean colX = true;
            for (int y = 0; y < 3; y++) {
                if (Game.Turn.o != oxButton[x][y].getValue()) rowO = false;
                if (Game.Turn.x != oxButton[x][y].getValue()) rowX = false;
                if (Game.Turn.o != oxButton[y][x].getValue()) colO = false;
                if (Game.Turn.x != oxButton[y][x].getValue()) colX = false;
            }
            if (rowO || colO) {
                resolve(Game.Turn.o);
                return;
            }
            if (rowX || colX) {
                resolve(Game.Turn.x);
                return;
            }
        }
    }

    private void resolve(Game.Turn value) {
        this.value = value;
        this.resolved = true;
        Image resolvedValue;
        if(value == Game.Turn.o) {
            resolvedValue = new Image("O_230px.png");
        } else {
            resolvedValue = new Image("X_230px.png");
        }
        valueImage.setImage(resolvedValue);
        valueImage.setVisible(true);
    }

    public Game.Turn getValue() {
        return value;
    }

    public Game.Turn getCurrentMove() {
        return ultimateBoard.getCurrentMove();
    }

    public boolean getResolved() {
        return resolved;
    }
}