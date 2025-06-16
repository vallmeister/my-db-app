package org.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ClearDb {

    private static final String DROP = "DROP TABLE CAR";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:./data/h2")) {
            Statement statement = connection.createStatement();
            statement.execute(DROP);
            System.out.println("DB deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
