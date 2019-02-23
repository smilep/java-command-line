package com.smilep.tcs.supercoders;

import java.util.Scanner;

public class InversionBaseEight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String input = scanner.nextLine();
        scanner.close();
        String[] inputArr = input.split(",");
        Integer[] inputIntArr = new Integer[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            inputIntArr[i] = Integer.parseInt(inputArr[i].trim());
        }
        Integer[] base8IntArray = new Integer[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            base8IntArray[i] = Integer.parseInt(Integer.toOctalString(inputIntArr[i]));
        }
        Integer[] repIntArray = new Integer[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            repIntArray[i] = calcSumOfDigits(base8IntArray[i]);
        }
        int count = 0;
        for (int i = 0; i < repIntArray.length; i++) {
            for (int j = i + 1; j < repIntArray.length; j++) {
                if (repIntArray[i] > repIntArray[j]) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    private static int calcSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

}
