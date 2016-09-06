package com.smilep.random;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.smilep.model.RunThisMethod;

public class StringGenerator {

    private static Properties prop = new Properties();

    static {
        InputStream input;
        try {
            input = new FileInputStream("config.properties");
            prop.load(input);
        } catch (Exception e) {
            System.out.println("property file not found");
            e.printStackTrace();
        }
    }

    @RunThisMethod
    public static void generateStrings(BufferedReader br) {
        String startingString = prop.getProperty("startingString");
        long start = Long.parseLong(startingString.replaceAll("DL-", ""));
        long numOfStrings = Long.parseLong(prop.getProperty("numOfStrings"));
        for (int i = 0; i < numOfStrings; i++) {
            System.out.println("DL-" + start++);
        }
    }

}
