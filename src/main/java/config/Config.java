package config;

import java.io.InputStream;
import java.util.Properties;


public class Config {
    private Properties properties;

    public Config() {
        properties = getProperties();
    }


    private Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load properties file" + e);
        }
        return prop;
    }

    public String getApplicationURL() {
        return properties.getProperty("application.url");
    }

    public String getApplicationUser() {
        return properties.getProperty("application.user");
    }

    public String getApplicationPassword() {
        return properties.getProperty("application.password");
    }
}


