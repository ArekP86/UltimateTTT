module com.example.ultimatettt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ultimatettt to javafx.fxml;
    exports com.example.ultimatettt;
}