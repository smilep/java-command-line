package com.smilep.google.codejam;
import java.util.*;
import java.io.*;
import java.time.Duration;
import java.time.Instant;

/**
 * @author Smile
 * 
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/0000000000088231
 * 
 * 2019 qualification
 *
 */
public class ForegoneSolution {
    public static void main(String[] args) {
        Scanner in = null;
        Instant start = null;
        Instant end = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            List<Integer> nums = new ArrayList<>();
            for (int i = 1; i <= t; ++i) {
                nums.add(in.nextInt());
            }
            start = Instant.now();
            for (int i = 0; i < t; ++i) {
                int num = nums.get(i);
                int fourIndex = 0;
                int a = 0;
                int b = 0;
                if (num / 10 < 1) {
                    a++;
                    b = num - a;
                    System.out.println((new StringBuffer()).append("Case #").append(i + 1).append(": " + a + " " + b));
                    continue;
                }
                fourIndex = reverseAsString(num).indexOf("4");
                a = fourIndex == 0 ? 1 : (int) Math.pow(10, fourIndex);
                b = num - a;
                while (hasFour(a) || hasFour(b)) {
                    fourIndex = reverseAsString(b).indexOf("4");
                    int incre = fourIndex == 0 ? 1 : (int) Math.pow(10, fourIndex);
                    a = a + incre;
                    b = b - incre;
                }
                System.out.println((new StringBuffer()).append("Case #").append(i + 1).append(": " + a + " " + b));
            }
        } finally {
            in.close();
            end = Instant.now();
            // System.out.println("Time taken : " + Duration.between(start, end).toMillis());
        }
    }

    private static boolean hasFour(int num) {
        return String.valueOf(num).contains("4");
    }

    private static String reverseAsString(int num) {
        String reverse = "";
        String str = "" + num;
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }
}