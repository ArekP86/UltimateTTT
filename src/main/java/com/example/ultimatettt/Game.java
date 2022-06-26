package com.example.ultimatettt;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Game extends BorderPane {
    public enum Turn {o, x, None}

    public enum Field {NW, N, NE, W, C, E, SW, S, SE}

    Turn starts;
    Turn currentMove;
    UltimateBoard ultimateBoard;
    History history = new History();
    Button anotherRoundButton = new Button("start new round");
    SidePanel sidePanel = new SidePanel(history, anotherRoundButton);

    public Game() {
        System.out.println("GAME CTOR");
        starts = Turn.o;
        currentMove = starts;
        sidePanel.setStartingMove(starts);
        sidePanel.setCurrentMove(currentMove);
        ultimateBoard = new UltimateBoard(this);

        setCenter(ultimateBoard);
        setRight(sidePanel);

        anotherRoundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                newRound();
                anotherRoundButton.setVisible(false);
            }
        });
        System.out.println("GAME CTOR END");
    }

    private void newRound() {
        if (Turn.o == starts) {
            starts = Turn.x;
        } else {
            starts = Turn.o;
        }
        history.clear();

        setCenter(null);
        ultimateBoard = new UltimateBoard(this);
        setCenter(ultimateBoard);
    }

    public void moveMade(Field boardField, Field field) {
        history.addEntry(currentMove, boardField, field);
        if (Turn.o == currentMove) {
            currentMove = Turn.x;
        } else {
            currentMove = Turn.o;
        }
        sidePanel.setCurrentMove(currentMove);
        if (boardField == field) {
            ultimateBoard.activateAllOXBoards();
        } else {
            ultimateBoard.activateOXBoard(field);
        }
    }

    public void point(Turn value) {
        sidePanel.point(value);
        ultimateBoard.deactivateAllOXBoards();
        anotherRoundButton.setVisible(true);
    }

    public Turn getCurrentMove() {
        return currentMove;
    }
}
