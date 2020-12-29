package utilities.generalUtilities;

import utilities.dictionary.PropertyFiles;
import utilities.exeptions.NullParamException;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// class for reading from property files

public class Environment {
    // in view of the fact that we have a few property files then each property file is in the Map
    // under its own map key
    private static final Map<String, Properties> propertyMap = new HashMap<>();
    private static Properties properties = new Properties();

    static {
        try {
            String key;
            // LOAD GENERAL PROPERTIES
            // reading the major configuration class of the configuration property
            // This file contains configurations for all test applications
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);

            properties.load(input);
            // define key for MAP as filename
            key = pathIndex(path);
            propertyMap.put(key != null ? key : "configuration" , properties);
            // create a new property for new property file
            properties = new Properties();

            // LOAD ENVIRONMENT SPECIFIC PROPERTIES
            if (System.getProperty("env") != null) {
                path = "src/test/resources/env/" + System.getProperty("env") + ".properties";
            } else {
                path = "src/test/resources/env/" + propertyMap.get(PropertyFiles.configuration.name()).getProperty("env") + ".properties";
            }
            input = new FileInputStream(path);

            properties.load(input);

            key = pathIndex(path);
            propertyMap.put(key != null ? key : "qa" , properties);
            properties = new Properties();

            // LOAD APPCONFIG SPECIFIC PROPERTIES
            if (System.getProperty("app") != null) {
                path = "src/test/resources/app/" + System.getProperty("app") + ".properties";
            } else {
                path = "src/test/resources/app/" + propertyMap.get(PropertyFiles.configuration.name()).getProperty("appconfig") + ".properties";
            }
            input = new FileInputStream(path);

            properties.load(input);

            key = pathIndex(path);
            propertyMap.put(key != null ? key : "appconfig" , properties);
            properties = new Properties();

            // LOAD APPLICATION SPECIFIC PROPERTIES
            if (System.getProperty("app") != null) {
                path = "src/test/resources/app/" + System.getProperty("appconfig") + ".properties";
            } else {
                path = "src/test/resources/app/" + propertyMap.get(PropertyFiles.appconfig.name()).getProperty("app") + ".properties";
            }
            input = new FileInputStream(path);

            properties.load(input);
            key = pathIndex(path);
            propertyMap.put(key != null ? key : "admin" , properties);
            properties = new Properties();

            // LOAD DEVELOP SPECIFIC PROPERTIES -- MANDATORY FOR READING OF TOKEN
            path = "src/test/resources/app/develop.properties";

            input = new FileInputStream(path);

            properties.load(input);
            key = pathIndex(path);
            propertyMap.put(key != null ? key : "develop" , properties);
            properties = new Properties();


            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // defining of path index/ for example develop is index for path
    // ("src/test/resources/app/(cut)develop(cut).properties")

    private static String pathIndex(String path){
        int beginIndex = path.lastIndexOf("/")+1;
        int endIndex = path.lastIndexOf(".");
        if (beginIndex > 0 && beginIndex < endIndex)
            return path.substring(beginIndex, endIndex);
        else if (beginIndex <= 0) return path.substring(0,endIndex);
        return null;
    }

    public static String getProperty(PropertyFiles pfile, String keyName) {

           // if (propertyMap.containsKey(keyName)) throw new NullParamException("No key");
        try{
            return propertyMap.get(pfile.name()).getProperty(keyName);
        }catch(NullPointerException npe){
            npe.getMessage();
        }
            return null;

    }

}
