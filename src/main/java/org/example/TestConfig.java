package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {
    Properties properties;
    FileManager fileManager;

    public TestConfig() {
        fileManager = new FileManager();
        properties = new Properties();
        loadConfigFile();
    }

    public void loadConfigFile() {
        try {
            FileInputStream fis = new FileInputStream(fileManager.getConfigFilePath());
            properties.load(fis);
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getApiKey() {
        return properties.getProperty("api-key");
    }

    public String getPhotosURI() {
        return properties.getProperty("baseURI") + properties.getProperty("resourceRoot");
    }

}
