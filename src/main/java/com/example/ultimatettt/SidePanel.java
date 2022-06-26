package com.example.ultimatettt;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SidePanel extends VBox {
    private int pointsO = 0;
    private int pointsX = 0;
    Label startingMoveLabel = new Label(" ");
    Label currentMoveLabel = new Label(" ");
    Label labelO = new Label("0");
    Label labelX = new Label("0");



    public SidePanel(History history, Button newGameButton) {
        GridPane header = new GridPane();

        header.addRow(0, new Label("Round started by: "), startingMoveLabel, new Label("Current player: "), currentMoveLabel);
        header.addRow(1, new Label("Player O points:"), labelO, new Label("Player X points:"), labelX);

        getChildren().add(header);
        getChildren().add(history);
        getChildren().add(newGameButton);
    }

    public void point(Game.Turn value) {
        if (Game.Turn.o == value) {
            pointsO++;
            labelO.setText(String.valueOf(pointsO));
        } else {
            pointsX++;
            labelX.setText(String.valueOf(pointsX));
        }
    }

    public void setStartingMove(Game.Turn starts) {
        startingMoveLabel.setText(starts.toString());
    }

    public void setCurrentMove(Game.Turn currentMove) {
        currentMoveLabel.setText(currentMove.toString());
    }
}
