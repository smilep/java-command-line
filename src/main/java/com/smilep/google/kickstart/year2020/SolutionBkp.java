package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;

public class SolutionBkp {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            Comparator<Integer> comparator = Collections.reverseOrder();
            for (int j = 1; j <= t; j++) {
                int numStrings = in.nextInt();
                int groupSize = in.nextInt();
                int score = 0;
                List<String> strs = new ArrayList<>();
                for (int i = 0; i < numStrings; i++) {
                    strs.add(in.next());
                }
                Collections.sort(strs, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String value = new String(o1);
                        String anotherString = new String(o2);
                        int len1 = value.length();
                        int len2 = anotherString.length();
                        int lim = Math.min(len1, len2);
                        char v1[] = value.toCharArray();
                        char v2[] = anotherString.toCharArray();

                        int k = 0;
                        while (k < lim) {
                            char c1 = v1[k];
                            char c2 = v2[k];
                            if (c1 != c2) {
                                return c1 - c2;
                            }
                            k++;
                        }
                        return len2 - len1;
                    }
                });
                List<List<String>> groupList = new ArrayList<List<String>>();
                for (int i = 0; i < numStrings; i = i + groupSize) {
                    groupList.add(strs.subList(i, i + groupSize));
                }
                for (int k = 0; k < groupList.size(); k++) {
                    List<String> groupStrs = groupList.get(k);
                    String shortestStr = new String(groupStrs.get(0));
                    for (String str : groupStrs) {
                        if (str.length() < shortestStr.length()) {
                            shortestStr = str;
                        }
                    }
                    List<String> matchingList = new ArrayList<String>(groupStrs);
                    matchingList.remove(shortestStr);
                    List<String> shortestStrCharList = new ArrayList<String>(Arrays.asList(shortestStr.split("")));
                    String matcher = "";
                    outer: for (int i = 0; i < shortestStrCharList.size(); i++) {
                        matcher = matcher + shortestStrCharList.get(i);
                        for (String str : matchingList) {
                            if (str.length() < 1 || !matcher.equals(str.substring(0, matcher.length()))) {
                                break outer;
                            }
                        }
                        score++;
                    }
                }
                System.out.println("Case #" + j + ": " + score);
            }
        } finally {
            in.close();
        }
    }

}