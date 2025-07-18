package com.chiranjeevkashyap.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    public static Properties load() throws IOException {
        Properties props = new Properties();
        try (InputStream input = DBConfig.class.getClassLoader().getResourceAsStream("database.properties")) {
            if (input == null) throw new NullPointerException("database.properties not found.");
            props.load(input);
        }
        return props;
    }
}
