package com.smilep.google.kickstart.year2020;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class StableWall {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int r = 1; r <= t; ++r) {
            int rows = in.nextInt();
            int columns = in.nextInt();
            String result = "-1";
            char[][] chars = new char[rows][columns];
            List<String> list = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                list.add(in.next());
            }
            int e = rows - 1;
            for (String item : list) {
                chars[e] = item.toCharArray();
                e--;
            }
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    set.add(chars[i][j]);
                }
            }
            String str = set.stream().map(String::valueOf).collect(Collectors.joining());
            Set<String> allSolutions = permutation(str);
            mainLoop:
            for (String solution : allSolutions) {
                char[][] solChars = new char[rows][columns];
                char[] moves = solution.toCharArray();
                for (int k = 0; k < moves.length; k++) {
                    char move = moves[k];
                    // Play the move
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < columns; j++) {
                            if (chars[i][j] == move) {
                                solChars[i][j] = move;
                            }
                        }
                    }
                    // check stability
                    if (!isStable(solChars, rows, columns, move)) {
                        break;
                    } else {
                        if (k == moves.length - 1) {
                            result = solution;
                            break mainLoop;
                        }
                    }
                }
            }
            System.out.println("Case #" + r + ": " + result);
        }
    }

    private static boolean isStable(char[][] chars, int rows, int columns, char move) {
        boolean result = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (move == chars[i][j]) {
                    if ((i == 0 || '\u0000' != chars[i - 1][j])) {
                        result = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return result;
    }

    private static Set<String> permutation(String str) {
        Set<String> set = new HashSet<>();
        permutation(set, "", str);
        return set;
    }

    private static void permutation(Set<String> set, String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            set.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permutation(set, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
