package org.example.data;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Migration {
    private static final Logger logger = Logger.getLogger(Migration.class);
    private static final Properties properties = new Properties();

    private Migration(){}

    public static void flywayMigration(){
        logger.info("Flyway migration execute");

        loadProperties();
        Flyway.configure()
                .dataSource(properties.getProperty("hibernate.connection.url"),
                        properties.getProperty("hibernate.connection.username"),
                        properties.getProperty("hibernate.connection.password"))
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();
    }

    private static void loadProperties(){
        try (InputStream inputStream = Migration.class.getClassLoader().getResourceAsStream("hibernate.properties")){
            properties.load(inputStream);
        } catch (IOException e){
            logger.fatal(e);
        }
    }
}
