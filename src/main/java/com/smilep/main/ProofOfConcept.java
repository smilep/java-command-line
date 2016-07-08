package com.smilep.main;

public class ProofOfConcept {

    public static void main(String[] args) {
        String input = "+--+-";
        System.out.println(getIndexOf(input, '-'));

    }

    private static int getIndexOf(String input, char chr) {
        char[] inputArray = input.toCharArray();
        int i = 0;
        for (char item : inputArray) {
            if (item != chr) {
                break;
            }
            i++;
        }
        return i - 1;
    }

}
