module com.example.tppoo {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    //opens com.example.tppoo to javafx.fxml;
    //exports com.example.tppoo;
    opens Controllers to javafx.fxml, com.google.gson, javafx.graphics;
    exports Controllers to javafx.fxml, com.google.gson, javafx.graphics;
    opens Models to javafx.fxml, com.google.gson, javafx.graphics;
    exports Models to javafx.fxml, com.google.gson, javafx.graphics;
    exports MainApplication to javafx.fxml, com.google.gson, javafx.graphics;
    opens MainApplication to javafx.fxml, com.google.gson, javafx.graphics;

}