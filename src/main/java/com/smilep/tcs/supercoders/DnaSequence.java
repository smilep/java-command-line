package com.smilep.tcs.supercoders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class DnaSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        /*if (size > input.length()) {
            System.out.println("None");
            scanner.close();
            return;
        }*/
        List<String> charList = Arrays.asList("A", "C", "G", "T").stream().filter(item -> input.contains(item))
                .collect(Collectors.toList());
        /*if (charList.size() < 1) {
            System.out.println("None");
        }*/
        List<String> allCombinations = generateCombinations(size, Arrays.asList("A", "C", "G", "T"));
        allCombinations.forEach(item -> System.out.println(item));
        /*String[] allCombinationsArray = getAllLists(charList.toArray(new String[0]), size);
        List<String> allCombinations = new ArrayList<>();
        Arrays.stream(allCombinationsArray).forEach(allCombinations::add);*/
        List<String> allFoundCombinations = new ArrayList<>();
        allCombinations.forEach(item -> {
            if (isOcurringMoreThanOnce(input, item)) {
                allFoundCombinations.add(item);
            }
        });
        if (allFoundCombinations.size() < 1) {
            System.out.println("None");
        } else {
            //allFoundCombinations.forEach(item -> System.out.println(item));
        }
        scanner.close();
        // allCombinations.forEach(item -> System.out.println(item));

    }

    private static boolean isOcurringMoreThanOnce(String input, String subStr) {
        if (!input.contains(subStr)) {
            return false;
        }
        String newInput = input.replaceFirst(subStr, "");
        return newInput.contains(subStr);
    }

    private static List<String> generateCombinations(int size, List<String> items) {
        if (size == 1) {
            return items;
        }
        Set<String> allCombinations = new HashSet<>();
        List<String> allSubCombinations = generateCombinations(size - 1, items);
        items.forEach(item -> {
            allSubCombinations.forEach(combination -> {
                StringBuilder builder = new StringBuilder(size);
                allCombinations.add(builder.append(item).append(combination).toString());
            });
        });
        return new ArrayList(allCombinations);
    }
    
    private static String[] getAllLists(String[] elements, int lengthOfList)
    {
        //initialize our returned list with the number of elements calculated above
        String[] allLists = new String[(int)Math.pow(elements.length, lengthOfList)];

        //lists of length 1 are just the original elements
        if(lengthOfList == 1) return elements; 
        else
        {
            //the recursion--get all lists of length 3, length 2, all the way up to 1
            String[] allSublists = getAllLists(elements, lengthOfList - 1);

            //append the sublists to each element
            int arrayIndex = 0;

            for(int i = 0; i < elements.length; i++)
            {
                for(int j = 0; j < allSublists.length; j++)
                {
                    //add the newly appended combination to the list
                    allLists[arrayIndex] = elements[i] + allSublists[j];
                    arrayIndex++;
                }
            }

            return allLists;
        }
    }

}
