package com.example.ultimatettt;
import javafx.beans.property.SimpleStringProperty;

public class HistoryEntry {
    SimpleStringProperty move;
    SimpleStringProperty player;
    SimpleStringProperty location;

    HistoryEntry(String move, String player, String location) {
        this.move = new SimpleStringProperty(move);
        this.player = new SimpleStringProperty(player);
        this.location = new SimpleStringProperty(location);
    }
}
