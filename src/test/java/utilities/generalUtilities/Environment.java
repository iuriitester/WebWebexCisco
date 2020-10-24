package utilities.generalUtilities;

import utilities.dictionary.PropertyFiles;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Environment {

    private static final Map<String, Properties> propertyMap = new HashMap<>();
    private static final Properties properties = new Properties();

    static {
        try {
            // LOAD GENERAL PROPERTIES
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);

            properties.load(input);
            propertyMap.put(path, properties);

            // LOAD ENVIRONMENT SPECIFIC PROPERTIES
            if (System.getProperty("env") != null) {
                path = "src/test/resources/env/" + System.getProperty("env") + ".properties";
            } else {
                path = "src/test/resources/env/" + propertyMap.get(PropertyFiles.CONFIGURATION.name()).getProperty("env") + ".properties";
            }
            input = new FileInputStream(path);

            properties.load(input);
            propertyMap.put(path, properties);

            // LOAD APPLICATION SPECIFIC PROPERTIES
            if (System.getProperty("env") != null) {
                path = "src/test/resources/app/" + System.getProperty("app") + ".properties";
            } else {
                path = "src/test/resources/app/" + propertyMap.get(PropertyFiles.CONFIGURATION.name()).getProperty("app") + ".properties";
            }
            input = new FileInputStream(path);

            properties.load(input);
            propertyMap.put(path, properties);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String getProperty(PropertyFiles pfile, String keyName) {
        return propertyMap.get(pfile.name()).getProperty(keyName);
    }

}
