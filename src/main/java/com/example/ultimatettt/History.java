package com.example.ultimatettt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class History extends TableView {
    TableView<HistoryEntry> table = new TableView<HistoryEntry>();
    ObservableList<HistoryEntry> data = FXCollections.observableArrayList();

    private int currentTurn = 1;

    public History() {
        clear();
        TableColumn MoveCol = new TableColumn("Move");
        MoveCol.setCellValueFactory(new PropertyValueFactory<>("Move"));
        TableColumn playerCol = new TableColumn("Player");
        playerCol.setCellValueFactory(new PropertyValueFactory("Player"));
        TableColumn locationCol = new TableColumn("Location");
        locationCol.setCellValueFactory(new PropertyValueFactory("Location"));
        table.getColumns().addAll(MoveCol, playerCol, locationCol);
    }

    public void clear() {
        data.clear();
        currentTurn = 1;
        HistoryEntry initialEntry = new HistoryEntry("Round Starts", "", "");
        data.add(initialEntry);

        table.setItems(data);
    }

    public void addEntry(Game.Turn turn, Game.Field boardField, Game.Field field) {

        HistoryEntry newEntry = new HistoryEntry(String.valueOf(currentTurn++), turn.toString(), boardField.toString() + " : " + field.toString());
        data.add(newEntry);

        table.setItems(data);
    }
}
