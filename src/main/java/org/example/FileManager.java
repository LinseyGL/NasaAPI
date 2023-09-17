package org.example;
import java.io.File;

public class FileManager {
    private final String sourceDirectory = "src\\main\\resources";
    private final String configFileName = "test-config.properties";
    private final String absolutePath = System.getProperty("user.dir");

    public String getConfigFilePath(){
        return absolutePath + File.separator + sourceDirectory + File.separator + configFileName;
    }

}
