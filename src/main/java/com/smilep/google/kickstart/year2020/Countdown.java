package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;

public class Countdown {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int r = 1; r <= t; ++r) {
            int arraySize = in.nextInt();
            int countDown = in.nextInt();
            List<Integer> nums = new ArrayList<>();
            int countdownCount = 0;
            for (int i = 0; i < arraySize; i++) {
                nums.add(in.nextInt());
            }
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) == countDown && nums.size() >= (i + countDown)) {
                    int tempCountdown = countDown + 1;
                    for (int j = i; j < i + countDown; j++) {
                        tempCountdown--;
                        if (nums.get(j) != tempCountdown) {
                            break;
                        }
                        if (j == (i + countDown - 1)) {
                            countdownCount++;
                            i = i + countDown - 1;
                            break;
                        }
                    }
                }
            }
            System.out.println("Case #" + r + ": " + countdownCount);
        }
    }
}
