module com.javafx.javafx {
    requires javafx.fxml;
    // If you are using JavaFX graphics
    requires java.sql;
    requires static lombok;
    requires javafx.controls; // Since you're using SQL connectivity

    opens com.javafx.javafx.models to javafx.base;
    opens com.javafx.javafx.controller to javafx.fxml;

    exports com.javafx.javafx;
}