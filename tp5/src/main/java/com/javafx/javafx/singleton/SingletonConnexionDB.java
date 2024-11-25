package com.javafx.javafx.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    private static Connection connection;

    private SingletonConnexionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp5", "root", "root");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}