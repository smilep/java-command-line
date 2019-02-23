package com.smilep.tcs.supercoders;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BadPermutations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.parseInt(scanner.nextLine());
        // int times = 1;
        for (int i = 0; i < times; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            List<Integer> factors = getFactors(num);
            //factors.forEach(item -> System.out.println(item));
            BigInteger size = new BigInteger(factors.size() + "");
            //System.out.println(calcFactorial(size).subtract((((size.subtract(BigInteger.ONE).multiply(calcFactorial(size.subtract(BigInteger.ONE)))).subtract(calcFactorial(size.subtract(BigInteger.ONE)))).add(BigInteger.ONE))));
            System.out.println(calcFactorial(size).subtract((calcFactorial(size.subtract(BigInteger.ONE)).multiply(new BigInteger("2")).add(new BigInteger("1")))));
        }
        scanner.close();
    }

    private static List<Integer> getFactors(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    private static BigInteger calcFactorial(BigInteger num) {
        BigInteger factorial = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(num) < 1; i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(new BigInteger(i + ""));
        }
        return factorial;
    }

}
