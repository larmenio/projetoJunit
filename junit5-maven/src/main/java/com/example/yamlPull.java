package com.example;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class yamlPull {

    public Map<String, Object> readYaml(String filePath) throws IOException {
        Yaml yaml = new Yaml();
        try (FileReader reader = new FileReader("junit5-maven/src/elements.yaml")) {
            return yaml.load(reader);
        }
    }
    public static void main(String[] args) throws IOException {
        yamlPull reader = new yamlPull();
        Map<String, Object> data = reader.readYaml("config.yaml");
        // Print the entire content for verification
        System.out.println(data);
    }
}
