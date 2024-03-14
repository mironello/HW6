package org.example.config;

import org.example.props.PropertyReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Database {

    private static final Database ITNSTANCE = new Database();

    private static Connection connection;

    private Database() {
        String url = PropertyReader.getConnectionUrlForPosgres();
        String user = PropertyReader.getUserForPostgres();
        String pass = PropertyReader.getPasswordForPostgres();

        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(String.format("SQL exception. Can not create connection"));
            throw new RuntimeException("Can not create connection");
        }
    }

    public static Database getInstance() {
        return ITNSTANCE;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void executeSqlScript(Connection connection, String filePath) throws IOException, SQLException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            String[] sqlStatements = stringBuilder.toString().split(";");
            Statement statement = connection.createStatement();
            for (String sqlStatement : sqlStatements) {
                statement.executeUpdate(sqlStatement);
            }
        }
    }


//    public int executeUpdate(String query) {
//        try (Statement statement = connection.createStatement()) {
//            return statement.executeUpdate(query);
//        } catch (SQLException e) {
//            System.out.println(String.format("Exception. REason: %s", e.getMessage()));
//            throw new RuntimeException("Can not run query.");
//        }
//    }
//
//    public void executeResult(String query) {
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(query);
//            while (resultSet.next()) {
//                TestData td = new TestData(resultSet.getInt("id"), resultSet.getString("name"));
//                System.out.println("----->" + td.toString());
//            }
//        } catch (SQLException e) {
//            System.out.println(String.format("Exception. Reason: %s", e.getMessage()));
//            throw new RuntimeException("Can not run query");
//        }
//    }



    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
