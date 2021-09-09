package com.smilep.leetcode;

public class Aug2020DetectCapital {
    public static void main(String[] args) {
        Aug2020DetectCapital program = new Aug2020DetectCapital();
        System.out.println(program.detectCapitalUse("USA"));
    }

    public boolean detectCapitalUse(String word) {
        boolean result = false;
        boolean firstCharCap = false;
        int capCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            if (Character.isUpperCase(chr)) {
                capCount++;
                if (i == 0) {
                    firstCharCap = true;
                }
            }
        }
        if (capCount == 1 && firstCharCap) {
            result = true;
        } else if (capCount == word.length()) {
            result = true;
        } else if (capCount == 0) {
            result = true;
        }
        return result;
    }
}
