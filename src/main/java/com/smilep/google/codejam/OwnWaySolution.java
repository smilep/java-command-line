package com.smilep.google.codejam;
import java.util.*;
import java.io.*;

/**
 * @author Smile
 * 
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881da
 * 
 * 2019 qualification
 *
 */
public class OwnWaySolution {
    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            List<Integer> sizes = new ArrayList<>();
            List<String> inputs = new ArrayList<>();
            for (int j = 1; j <= t; ++j) {
                sizes.add(in.nextInt());
                inputs.add(in.next());
            }
            for (int j = 0; j < t; ++j) {
                int size = sizes.get(j);
                String input = inputs.get(j);
                String output = new String(input);
                String[] outArr = input.split("");
                for (int i = 0; i < outArr.length; i++) {
                    if (outArr[i].equalsIgnoreCase("E")) {
                        outArr[i] = "S";
                    } else {
                        outArr[i] = "E";
                    }
                }
                StringBuilder builder = new StringBuilder();
                Arrays.stream(outArr).forEach(item -> {
                    builder.append(item);
                });
                output = builder.toString();
                System.out.println((new StringBuilder()).append("Case #").append(j + 1).append(": ").append(output).toString());
            }
        } finally {
            in.close();
        }
    }

}