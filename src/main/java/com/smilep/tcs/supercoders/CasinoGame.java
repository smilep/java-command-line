package com.smilep.tcs.supercoders;

import java.util.Scanner;

public class CasinoGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        String[] inputArr = input.split(",");
        int money = Integer.parseInt(inputArr[inputArr.length - 1]);
        Integer[] gameValues = new Integer[inputArr.length - 2];
        for (int i = 0; i < inputArr.length - 2; i++) {
            gameValues[i] = Integer.parseInt(inputArr[i + 1]);
        }
        for (Integer item : gameValues) {
            if (money / 2 <= item) {
                money = money - money / 2 + item;
            }
        }
        System.out.println(money);
    }

}
