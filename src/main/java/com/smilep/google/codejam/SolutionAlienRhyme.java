package com.smilep.google.codejam;
import java.util.*;
import java.util.regex.Pattern;
import java.io.*;

/**
 * @author Smile
 * 
 * https://codingcompetitions.withgoogle.com/codejam/round/0000000000051635
 * Round 1 2019
 *
 */
public class SolutionAlienRhyme {

    public static void main(String[] args) throws IOException {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for (int l = 1; l <= t; ++l) {
                int num = in.nextInt();
                List<String> words = new ArrayList<>();
                List<String> matchedWords = new ArrayList<>();
                for (int n = 1; n <= num; ++n) {
                    words.add(in.next());
                }
                words.sort(Comparator.comparingInt(String::length).reversed());
                Set<String> suffixes = new HashSet<>();
                Iterator<String> wordIterator = words.iterator();
                while (wordIterator.hasNext()) {
                    String word = wordIterator.next();
                    if (matchedWords.contains(word)) {
                        continue;
                    }
                    int wordLength = word.length();
                    wordIterator.remove();
                    String pattern = ".*" + word + "$";
                    outerFor: for (int i = 1; i <= wordLength; i++) {
                        for (String item : words) {
                            if (Pattern.matches(pattern, item) && !suffixes.contains(word) && !matchedWords.contains(item)) {
                                suffixes.add(word);
                                matchedWords.add(item);
                                break outerFor;
                            }
                        }
                        word = word.substring(1);
                        pattern = ".*" + word + "$";
                    }
                }
                System.out.println("Case #" + l + ": " + (suffixes.size() * 2));
            }
        } finally {
            in.close();
        }

    }

}