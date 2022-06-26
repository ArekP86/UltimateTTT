package com.example.ultimatettt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;


public class History extends TableView {
    ObservableList<HistoryEntry> data = FXCollections.observableArrayList(new HistoryEntry("Round start", "", ""));

    private int currentTurn = 1;

    public History() {
        TableColumn<HistoryEntry, String> moveCol = new TableColumn("Move");
        moveCol.setCellValueFactory(
                new PropertyValueFactory<>("Move"));
        TableColumn<HistoryEntry, String>  playerCol = new TableColumn("Player");
        playerCol.setCellValueFactory(
                new PropertyValueFactory<>("Player"));
        TableColumn<HistoryEntry, String>  locationCol = new TableColumn("Location");
        locationCol.setCellValueFactory(
                new PropertyValueFactory<>("Location"));
        getColumns().add(moveCol);
        getColumns().add(playerCol);
        getColumns().add(locationCol);
        getItems().add(new HistoryEntry("Round start", " ", " "));
//        clear();
        refresh();
    }

    public void clear() {
        currentTurn = 1;
        HistoryEntry initialEntry = new HistoryEntry("Round Starts", "", "");
        getItems().clear();
        getItems().add(initialEntry);
        refresh();

    }

    public void addEntry(Game.Turn turn, Game.Field boardField, Game.Field field) {

        getItems().add(new HistoryEntry(String.valueOf(currentTurn++), turn.toString(), boardField.toString() + " : " + field.toString()));
        refresh();
    }
}
