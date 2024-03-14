package org.example.service;


import org.example.config.Database;
import org.example.elements.LongestProject;
import org.example.elements.MaxProjectCountClient;
import org.example.elements.MaxSalaryWorker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSqlFile("src/main/resources/sql/find_max_projects_client.sql"));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                result.add(new MaxProjectCountClient(name, projectCount));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

 public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSqlFile("src/main/resources/sql/find_longest_project.sql"));
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                result.add(new LongestProject(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(readSqlFile("src/main/resources/sql/find_max_salary_worker.sql"));
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int id = resultSet.getInt("id");
                result.add(new MaxSalaryWorker(name, id ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    private static String readSqlFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

}