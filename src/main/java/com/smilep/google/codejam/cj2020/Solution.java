package com.smilep.google.codejam.cj2020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int cases = in.nextInt();
            for (int t = 1; t <= cases; t++) {
                List<Interval> intervals = new ArrayList<>();
                int activitiesNum = in.nextInt();
                for (int i = 0; i < activitiesNum; i++) {
                    int startMins = in.nextInt();
                    int endMins = in.nextInt();
                    intervals.add(new Interval(startMins, endMins));
                }
                Collections.sort(intervals, (Interval i1, Interval i2) -> i1.start.compareTo(i2.start));
                String result = "";

                System.out.println("Case #" + t + ": " + result);
            }
        } finally {
            in.close();
        }
    }

}

class Interval {
    Integer start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
