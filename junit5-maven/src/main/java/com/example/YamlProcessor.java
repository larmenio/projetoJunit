package com.example;

import java.util.Map;

public class YamlProcessor {

    private Map<String, Object> configData;

    public YamlProcessor(Map<String, Object> configData) {
        this.configData = configData;
    }

    public void processDatabaseConfig() {
        Map<String, Object> databaseConfig = (Map<String, Object>) configData.get("junit5-maven/src/elements.yaml");

        String username = (String) databaseConfig.get("username_field_ID");
        String password = (String) databaseConfig.get("password_field_ID");

        // Process the database information
        System.out.println("Connecting to database at: " + username);
        System.out.println("Using username: " + password);
        // You would normally use this info to connect to the DB.
    }
}
