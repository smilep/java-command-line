package com.smilep.google.codejam;

import java.io.BufferedReader;
import java.io.IOException;

import com.smilep.model.RunThisMethod;

/**
 * @author SmileP
 * 
 *         Qualification Round 2016 URL :
 *         https://code.google.com/codejam/contest/6254486/dashboard#s=p1
 * 
 */
public class RevengeOfPancakes {

    @RunThisMethod
    public static void fixPancakes(BufferedReader br) throws NumberFormatException, IOException {
        String strLine = "";
        int i = 0;
        while ((strLine = br.readLine()) != null) {
            // Ignore first line as it contains number of test cases
            if (i > 0) {
                fixPancakes(strLine, i);
            }
            i++;
        }
    }

    private static void fixPancakes(String input, int caseNum) {
        if (!input.contains("-")) {
            System.out.println("Case #" + caseNum + ": " + 0);
        } else {
            int numOfFlips = 0;
            while (input.contains("-")) {
                if (input.indexOf("+") == -1 || input.indexOf("-") < input.indexOf("+")) {
                    input = new String(invertPancakes(input, getIndexOf(input, '-')));
                } else {
                    input = new String(invertPancakes(input, getIndexOf(input, '+')));
                }
                numOfFlips++;
            }
            System.out.println("Case #" + caseNum + ": " + numOfFlips);
        }
    }

    private static String invertPancakes(String input, int index) {
        input = new StringBuilder(input).toString();
        String input1 = input.substring(0, index + 1);
        String input2 = input.substring(index + 1, input.length());
        input1 = new StringBuilder(input1).reverse().toString();
        input1 = input1.replaceAll("-", "M");
        input1 = input1.replaceAll("\\+", "-");
        input1 = input1.replaceAll("M", "+");
        return new StringBuilder().append(input1).append(input2).toString();
    }

    private static int getIndexOf(String input, char chr) {
        char[] inputArray = input.toCharArray();
        int i = 0;
        for (char item : inputArray) {
            if (item != chr) {
                break;
            }
            i++;
        }
        return i - 1;
    }

}
