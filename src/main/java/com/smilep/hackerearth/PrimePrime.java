package com.smilep.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.smilep.model.RunThisMethod;

/**
 * @author SmileP
 * 
 *         URL :
 *         https://www.hackerearth.com/problem/algorithm/micro-and-prime-prime-1/
 * 
 */
public class PrimePrime {

    public static int[] primes = new int[1000001];
    public static int[] primePrimes = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        printPrimePrime(br);
    }

    @RunThisMethod
    public static void printPrimePrime(BufferedReader br) throws NumberFormatException, IOException {
        initialize();
        String strLine;
        int i = 0;
        while ((strLine = br.readLine()) != null) {
            // Ignore first line as it contains number of test cases
            if (i > 0) {
                printPrimePrime(strLine);
            }
            i++;
        }
    }

    private static void printPrimePrime(String input) {
        String[] inputArray = input.split(" ");
        int left = Integer.parseInt(inputArray[0]);
        int right = Integer.parseInt(inputArray[1]);
        System.out.println(primePrimes[right] - primePrimes[left - 1]);
    }

    private static int isPrime(int item) {
        return primes[item];
    }

    private static void initialize() {
        Arrays.fill(primes, 1);
        primes[0] = 0;
        primes[1] = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        primePrimes[0] = 0;
        primePrimes[1] = 0;
        int numOfPrime = 0;
        int numOfPrimePrime = 0;
        for (int i = 2; i < primePrimes.length; i++) {
            if (isPrime(i) == 1) {
                numOfPrime++;
            }
            if (isPrime(numOfPrime) == 1) {
                numOfPrimePrime++;
            }
            primePrimes[i] = numOfPrimePrime;
        }
    }

}
