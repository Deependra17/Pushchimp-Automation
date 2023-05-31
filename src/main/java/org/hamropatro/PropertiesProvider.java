package org.hamropatro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesProvider {
    final static Properties prop = new Properties();

    public static void loadProperties() {
        try (InputStream input = new FileInputStream("/home/hamropatro/IdeaProjects/HarmroAudience/src/main/resources/testProperties.properties")) {
            prop.load(input);
//            System.out.println(prop.getProperty("pushchimp.url"));
//            System.out.println(prop.getProperty("pushchimp.email"));
//            System.out.println(prop.getProperty("pushchimp.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Properties getProperties(){
        return prop;
    }
}
