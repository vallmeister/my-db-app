package org.example;

import java.sql.*;

public class App {

    private static final String CREATE = "CREATE TABLE CAR(ID INTEGER NOT NULL PRIMARY KEY, NAME VARCHAR(255), KM INTEGER)";
    private static final String INSERT = "INSERT INTO CAR VALUES(1, 'Ford', 5000)";

    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:./data/h2")) {
            Statement statement = connection.createStatement();
            statement.execute(CREATE);
            statement.execute(INSERT);
            System.out.println("DB created");

            ResultSet rs = statement.executeQuery("SELECT * FROM Car");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
