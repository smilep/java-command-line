package com.smilep.google.codejam;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author SmileP
 * 
 *         2016 Qualification round URL :
 *         https://code.google.com/codejam/contest/6254486/dashboard#s=p0
 * 
 */
public class SheepCounter {

    public static void countSheep(BufferedReader br) throws NumberFormatException, IOException {
        String strLine;
        int i = 0;
        while ((strLine = br.readLine()) != null) {
            // Ignore first line as it contains number of test cases
            if (i > 0) {
                SheepCounter.countSheep(Integer.parseInt(strLine), i);
            }
            i++;
        }
    }

    private static void countSheep(int num, int caseNum) {
        boolean zero = false;
        boolean one = false;
        boolean two = false;
        boolean three = false;
        boolean four = false;
        boolean five = false;
        boolean six = false;
        boolean seven = false;
        boolean eight = false;
        boolean nine = false;
        int i = 1;
        String number = "";
        while (!zero || !one || !two || !three || !four || !five || !six || !seven || !eight || !nine) {
            if (num == 0) {
                number = "INSOMNIA";
                break;
            }
            number = num * i + "";
            if (number.contains("0")) {
                zero = true;
            }
            if (number.contains("1")) {
                one = true;
            }
            if (number.contains("2")) {
                two = true;
            }
            if (number.contains("3")) {
                three = true;
            }
            if (number.contains("4")) {
                four = true;
            }
            if (number.contains("5")) {
                five = true;
            }
            if (number.contains("6")) {
                six = true;
            }
            if (number.contains("7")) {
                seven = true;
            }
            if (number.contains("8")) {
                eight = true;
            }
            if (number.contains("9")) {
                nine = true;
            }
            i++;
        }
        System.out.println("Case #" + caseNum + ": " + number);
    }

}
