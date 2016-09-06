package com.smilep.random;

import java.io.BufferedReader;
import java.util.Properties;

import com.smilep.model.RunThisMethod;
import com.smilep.util.Util;

public class StringGenerator {

    private static Properties properties = Util.properties;

    @RunThisMethod
    public static void generateStrings(BufferedReader br) {
        String startingString = properties.getProperty("startingString");
        long start = Long.parseLong(startingString.replaceAll("DL-", ""));
        long numOfStrings = Long.parseLong(properties.getProperty("numOfStrings"));
        for (int i = 0; i < numOfStrings; i++) {
            System.out.println("DL-" + start++);
        }
    }

}
