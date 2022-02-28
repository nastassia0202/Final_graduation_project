package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static Properties properties = null;
    private static String filename = "config.properties";

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getProjectAnnouncement() {
        return properties.getProperty("ProjectAnnouncement");
    }

    public static String getBrowserName() {
        return properties.getProperty("browserType");
    }

    public static String getProjectName() {
        return properties.getProperty("ProjectName");
    }

    public static String getEmail() {
        return properties.getProperty("username");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
    public static String getProjectType() {
        return properties.getProperty("ProjectType");
    }

    public static boolean isHeadless() {
        return properties.getProperty("headless").equalsIgnoreCase("true");
    }

    public static boolean showAnnouncement() {
        return properties.getProperty("showAnnouncement").equalsIgnoreCase("true");
    }

    public static int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }

}
