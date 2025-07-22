import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {
    public static String getApiKey() {
        try (InputStream input = ApiConfig.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty("api.key");
        } catch (Exception ex) {
            throw new RuntimeException("Error cargando configuración", ex);
        }
    }

    public static void main(String[] args) {
        System.out.println((ApiConfig.getApiKey())); // String Class
    }
}