package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int r = 1; r <= t; ++r) {
            int n = in.nextInt();
            int[] array = new int[n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                array[i] = in.nextInt();
                if (array[i] >= 0 && isPerfectSquare(array[i])) {
                    count++;
                }
            }
            for (int i = 0; i < n; i++) {
                int diff = 2;
                while (diff + i <= n) {
                    int[] arrayToCheck = Arrays.copyOfRange(array, i, diff + i);
                    if (isPerfectSquare(arrayToCheck)) {
                        count++;
                    }
                    diff++;
                }
            }
            System.out.println("Case #" + r + ": " + count);
        }
    }

    private static boolean isPerfectSquare(int... nums) {
        int number = 0;
        for (int num : nums) {
            number = number + num;
        }
        if (number == 0) {
            return true;
        }
        if (number < 0) {
            return false;
        }
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }
}