package com.smilep.main;

public class ProofOfConcept {

    public static void main(String[] args) {
        /*String input = "+--+-";
        System.out.println(getIndexOf(input, '-'));*/
        StringBuilder outputBuffer = new StringBuilder(10000000/4);
        for (int i = 0; i < 10000000/4; i++){
           outputBuffer.append("ACGT");
        }
        System.out.println(outputBuffer.toString());

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
