package com.chiranjeevkashyap.query;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Scanner;

public enum Query {
    SELECT_EMP("sql/select.sql"),
    SELECT_NAME_("unknownfile");

    private final String query;

    Query(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("SQL path is required for query: " + name());
        }
        this.query = loadQuery(name);
    }

    private static String loadQuery(String path) {
        try (InputStream inputStream = Query.class.getClassLoader().getResourceAsStream(path)) {
            if (inputStream == null) throw new NullPointerException("SQL file not found in resources: " + path);
            return new Scanner(inputStream, "UTF-8").useDelimiter("\\A").next().trim().replaceAll(";\\s*$", "");
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load SQL query: " + path, e);
        }
    }

    public String read() {
        return query;
    }
}
