package com.example.ultimatettt;
import javafx.beans.property.SimpleStringProperty;

public class HistoryEntry {
    SimpleStringProperty Move;
    SimpleStringProperty Player;
    SimpleStringProperty Location;

    HistoryEntry(String move, String player, String location) {
        this.Move = new SimpleStringProperty( move);
        this.Player = new SimpleStringProperty(player);
        this.Location = new SimpleStringProperty(location);
    }
}
