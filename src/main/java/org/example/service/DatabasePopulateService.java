package org.example.service;


import org.example.config.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.example.config.Database.executeSqlScript;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try {
            Connection connection = Database.getInstance().getConnection();
            String filePath = "src/main/resources/sql/populate_db.sql";
            executeSqlScript(connection, filePath);
            System.out.println("Database populated successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


}
