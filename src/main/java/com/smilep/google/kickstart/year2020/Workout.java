package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;

public class Workout {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            Comparator<Integer> comparator = Collections.reverseOrder();
            for (int j = 1; j <= t; j++) {
                int numSessions = in.nextInt();
                int maxNewSessions = in.nextInt();
                int minDifficulty = 0;
                List<Integer> sessionTimes = new ArrayList<>();
                for (int i = 0; i < numSessions; i++) {
                    sessionTimes.add(in.nextInt());
                }
                List<Integer> maxDifficulties = new ArrayList<>();
                for (int i = 0; i < sessionTimes.size() - 1; i++) {
                    maxDifficulties.add(sessionTimes.get(i + 1) - sessionTimes.get(i));
                }
                for (int i = 0; i < maxNewSessions; i++) {
                    Collections.sort(maxDifficulties, comparator);
                    int maxDifficulty = maxDifficulties.get(0);
                    if (maxDifficulty > 1) {
                        if (maxDifficulty % 2 != 0) {
                            maxDifficulty++;
                        }
                        maxDifficulties.remove(0);
                        maxDifficulties.add(maxDifficulty / 2);
                        maxDifficulties.add(maxDifficulty / 2);
                    }
                }
                Collections.sort(maxDifficulties, comparator);
                minDifficulty = maxDifficulties.get(0);
                System.out.println("Case #" + j + ": " + minDifficulty);
            }
        } finally {
            in.close();
        }
    }

}