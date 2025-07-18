package com.chiranjeevkashyap.query;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public enum Query {
    SELECT_EMP("select.sql");
    private final Path path;

    Query(String path) {
        if (path == null) {
            throw new NullPointerException("Path must not be null");
        }
        if (path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path must not be empty");
        }
        this.path = Paths.get("src/main/resources/sql/" + path);
    }

    public String getQuery() throws IOException {
        return new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
    }
}
