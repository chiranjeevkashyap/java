package com.chiranjeevkashyap;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.chiranjeevkashyap.config.DBConfig;
import com.chiranjeevkashyap.model.Employee;
import com.chiranjeevkashyap.query.Query;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(Query.SELECT_EMP.getQuery());
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employee employee = Employee.getInstance();
                employee.id = resultSet.getLong("id");
                employee.name = resultSet.getString("name");
                employee.age = resultSet.getInt("age");
                System.out.println(employee);
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws IOException, SQLException {
        Properties props = DBConfig.load();
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.username");
        String password = props.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);
    }
}
