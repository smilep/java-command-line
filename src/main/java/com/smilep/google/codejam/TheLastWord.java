package com.smilep.google.codejam;

import java.io.BufferedReader;
import java.io.IOException;

import com.smilep.model.RunThisMethod;

/**
 * @author SmileP
 * 
 * 
 *         Round 1A 2016 URL :
 *         https://code.google.com/codejam/contest/4304486/dashboard#s=p0
 * 
 */
public class TheLastWord {

    @RunThisMethod
    public static void findLastWord(BufferedReader br) throws NumberFormatException, IOException {
        String strLine = "";
        int i = 0;
        while ((strLine = br.readLine()) != null) {
            // Ignore first line as it contains number of test cases
            if (i > 0) {
                findLastWord(strLine, i);
            }
            i++;
        }
    }

    private static void findLastWord(String input, int caseNum) {
        char[] inputArray = input.toCharArray();
        String output = inputArray[0] + "";
        for (int i = 1; i < inputArray.length; i++) {
            char item = inputArray[i];
            if (output.charAt(output.length() - 1) < output.charAt(0)) {
                if (item >= output.charAt(0)) {
                    output = appendChar(output, item, "left");
                } else {
                    output = appendChar(output, item, "right");
                }
            } else {
                if (item >= output.charAt(output.length() - 1)) {
                    output = appendChar(output, item, "left");
                } else {
                    output = appendChar(output, item, "right");
                }
            }
        }
        System.out.println("Case #" + caseNum + ": " + output);
    }

    private static String appendChar(String input, char chr, String direction) {
        if ("left".equalsIgnoreCase(direction)) {
            input = (chr + "").concat(input);
        } else if ("right".equalsIgnoreCase(direction)) {
            input = input.concat(chr + "");
        }
        return input;
    }

}
