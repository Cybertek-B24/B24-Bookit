package com.bookit.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Dynamically loads test data to variables, according to the env value.
 * First checks if "env" value was passed from maven command line.
 * If yes, it will use that value.
 * If not, it will use value in local configuration.properties file
 *
 *
 * */

public class Environment {

        public static final String URL;
        public static final String BASE_URL;
        public static final String DB_USERNAME;
        public static final String DB_PASSWORD;
        public static final String DB_URL;
        public static final String TEACHER_EMAIL;
        public static final String TEACHER_PASSWORD;
        public static final String MEMBER_EMAIL;
        public static final String MEMBER_PASSWORD;
        public static final String LEADER_EMAIL;
        public static final String LEADER_PASSWORD;

        static { //runs once in beginning when we use the class- static block
            //class to read from .properties files
            Properties properties = null;
            String environment = System.getProperty("env") != null ? System.getProperty("env") : ConfigurationReader.getProperty("env");
            //String environment = ConfigurationReader.get("environment");

            try {

                String path = System.getProperty("user.dir") + "/src/test/resources/env/" + environment + ".properties";

                FileInputStream input = new FileInputStream(path);
                properties = new Properties();
                properties.load(input);
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            URL = properties.getProperty("url");
            BASE_URL = properties.getProperty("base_url");
            DB_USERNAME = properties.getProperty("dbUsername");
            DB_PASSWORD = properties.getProperty("dbPassword");
            DB_URL = properties.getProperty("dbUrl");
            TEACHER_EMAIL = properties.getProperty("teacher_email");
            TEACHER_PASSWORD = properties.getProperty("teacher_password");
            MEMBER_EMAIL = properties.getProperty("team_member_email");
            MEMBER_PASSWORD = properties.getProperty("team_member_password");
            LEADER_EMAIL = properties.getProperty("team_leader_email");
            LEADER_PASSWORD = properties.getProperty("team_leader_password");


        }

}
