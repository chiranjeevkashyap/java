package com.chiranjeevkashyap.query;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public enum Query {
    SELECT_EMP("sql/select.sql");

    private final String name;

    Query(String name) {
        if (name == null) {
            throw new NullPointerException("Path must not be null");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        this.name = name;
    }

    public String getQuery() throws IOException {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name)) {
            if (inputStream == null) throw new NullPointerException("SQL file not found in resources: " + name);
            return new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next().trim();
        }
    }
}
