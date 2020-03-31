import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
    
    static {
        allCombs = permute("ABCDE");
    }
    
    private static Set<String> allCombs;

    public static void main(String[] args) throws IOException {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            int f = in.nextInt();
            List<Character> allChars = new ArrayList<>(5);
            allChars.add('A');
            allChars.add('B');
            allChars.add('C');
            allChars.add('D');
            allChars.add('E');
            for (int c = 1; c <= t; ++c) {
                List<String> elements = new ArrayList<>();
                StringBuilder element = new StringBuilder();
                for (int q = 1; q <= f; ++q) {
                    if (q > 4 && q % 5 == 0) {
                        List<Character> elementChars = element.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
                        List<Character> newChars = new ArrayList<>(allChars);
                        newChars.removeAll(elementChars);
                        element.append(newChars.get(0));
                        elements.add(element.toString());
                        element = new StringBuilder();
                        q++;
                    }
                    String output = in.next();
                    element.append(output);
                }
                List<String> tempAllCombs = new ArrayList<>(allCombs);
                tempAllCombs.removeAll(elements);
                System.out.println(tempAllCombs.get(0));
                String anotherOut = in.next();
                if(anotherOut.equalsIgnoreCase("N")) {
                    System.exit(0);
                }
            }
        } finally {
            in.close();
        }
    }
    
    public static Set<String> permute(String chars)
    {
      // Use sets to eliminate semantic duplicates (aab is still aab even if you switch the two 'a's)
      // Switch to HashSet for better performance
      Set<String> set = new TreeSet<String>();

      // Termination condition: only 1 permutation for a string of length 1
      if (chars.length() == 1)
      {
        set.add(chars);
      }
      else
      {
        // Give each character a chance to be the first in the permuted string
        for (int i=0; i<chars.length(); i++)
        {
          // Remove the character at index i from the string
          String pre = chars.substring(0, i);
          String post = chars.substring(i+1);
          String remaining = pre+post;

          // Recurse to find all the permutations of the remaining chars
          for (String permutation : permute(remaining))
          {
            // Concatenate the first character with the permutations of the remaining chars
            set.add(chars.charAt(i) + permutation);
          }
        }
      }
      return set;
    }
}