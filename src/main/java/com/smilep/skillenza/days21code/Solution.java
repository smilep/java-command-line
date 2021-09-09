package com.smilep.skillenza.days21code;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int n = 0; n < t; n++) {
            int num = sc.nextInt();
            int size = num * 2 - 1;
            System.out.println(size);
            List<String> strs = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                String str = "";
                String.format("%-" + n + "s", str);
                System.out.println(str);
            }
        }

    }
}
