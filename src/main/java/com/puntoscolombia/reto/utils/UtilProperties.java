package com.puntoscolombia.reto.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilProperties {
    public static String getData(String propertie){
        String myPropertie = propertie;
        Properties properties= new java.util.Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("data.properties");
            properties.load(input);

            return properties.getProperty(myPropertie);

        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
