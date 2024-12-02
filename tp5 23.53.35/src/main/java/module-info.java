module com.javafx.tp5 {
    // JavaFX module dependencies
    requires javafx.fxml;
    requires java.sql;
    requires javafx.controls;

    // Export the controller package
    exports com.javafx.tp5.controller to javafx.fxml;

    // Open the controller package for reflection
    opens com.javafx.tp5.controller to javafx.fxml;

    // Export other necessary packages
    exports com.javafx.tp5;
    exports com.javafx.tp5.models;
    exports com.javafx.tp5.dao;
    exports com.javafx.tp5.metier;

    // Open other packages for reflection if needed
    opens com.javafx.tp5.models to javafx.base;
}