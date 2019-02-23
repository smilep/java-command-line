package com.smilep.tcs.supercoders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class DnaSequence2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        scanner.close();
        //long startTime = System.currentTimeMillis();
        SortedSet<String> strings = new TreeSet<>();
        if (size > input.length()) {
            System.out.println("None");
            return;
        }
        for (int i = 0; i < input.length() - (size*2); i++) {
            String item = input.substring(i, i + size);
            if (isValid(item) && !strings.contains(item) && isOcurringMoreThanOnce(input, item)) {
                strings.add(item);
            }
        }
        if(strings.size() == 0) {
            System.out.println("None");
        }
        //Collections.sort(strings);
        strings.forEach(item -> System.out.println(item));
        /*long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time : " + totalTime + " millisecs");*/
    }

    private static boolean isValid(String str) {
        return str.matches("[ACGT]*");
    }

    private static boolean isOcurringMoreThanOnce(String input, String subStr) {
        return input.replaceFirst(subStr, "").contains(subStr);
    }

}
