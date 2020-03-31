import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class SolutionRockPaperSci {

    public static void main(String[] args) throws IOException {
        Scanner in = null;
        try {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int t = in.nextInt();
            for (int c = 1; c <= t; ++c) {
                int numOfAdrs = in.nextInt();
                List<String> adverseries = new ArrayList<>(numOfAdrs);
                for (int l = 1; l <= numOfAdrs; ++l) {
                    adverseries.add(in.next());
                }
                int MAX_LENGTH = 500;
                List<String> cleanedAdverseries = getCleanedAdvrs(adverseries, MAX_LENGTH);
                List<Set<Character>> listOfCharSet = getListOfCharSet(cleanedAdverseries, MAX_LENGTH);

                StringBuilder result = new StringBuilder();
                boolean isResultAchieved = false;
                boolean isResultDisplayed = false;
                while (!isResultAchieved) {
                    for (int i = 0; i < MAX_LENGTH; i++) {
                        if (cleanedAdverseries.size() < 1) {
                            break;
                        }
                        Set<Character> item = new HashSet<>();
                        item = listOfCharSet.get(i);
                        if (item.size() > 2) {
                            System.out.println("Case #" + c + ": IMPOSSIBLE");
                            isResultAchieved = true;
                            isResultDisplayed = true;
                            break;
                        } else if (item.size() == 2) {
                            if (i >= (MAX_LENGTH - 1)) {
                                System.out.println("Case #" + c + ": IMPOSSIBLE");
                                isResultAchieved = true;
                                isResultDisplayed = true;
                                break;
                            }
                            if (item.contains('R') && item.contains('S')) {
                                result.append("R");
                                int index = i;
                                cleanedAdverseries.removeIf(advrs -> advrs.charAt(index) == 'S');
                                listOfCharSet = getListOfCharSet(cleanedAdverseries, MAX_LENGTH);
                            } else if (item.contains('S') && item.contains('P')) {
                                result.append("S");
                                int index = i;
                                cleanedAdverseries.removeIf(advrs -> advrs.charAt(index) == 'P');
                                listOfCharSet = getListOfCharSet(cleanedAdverseries, MAX_LENGTH);
                            } else if (item.contains('R') && item.contains('P')) {
                                result.append("P");
                                int index = i;
                                cleanedAdverseries.removeIf(advrs -> advrs.charAt(index) == 'R');
                                listOfCharSet = getListOfCharSet(cleanedAdverseries, MAX_LENGTH);
                            }
                        } else if (item.size() < 2) {
                            if (item.contains('R')) {
                                result.append("P");
                            } else if (item.contains('S')) {
                                result.append("R");
                            } else if (item.contains('P')) {
                                result.append("S");
                            }
                            isResultAchieved = true;
                            isResultDisplayed = false;
                            break;
                        }
                    }
                }

                if (!isResultDisplayed) {
                    System.out.println("Case #" + c + ": " + result.toString());
                }
            }
        } finally {
            in.close();
        }
    }

    private static List<String> getCleanedAdvrs(List<String> adverseries, int MAX_LENGTH) {
        List<String> cleanedAdverseries = new ArrayList<>();
        adverseries.forEach(item -> {
            if (item.length() < MAX_LENGTH) {
                StringBuilder builder = new StringBuilder();
                while (builder.length() < MAX_LENGTH) {
                    builder.append(item);
                }
                cleanedAdverseries.add(builder.substring(0, MAX_LENGTH).toString());
            }
        });
        return cleanedAdverseries;
    }

    private static List<Set<Character>> getListOfCharSet(List<String> cleanedAdverseries, int MAX_LENGTH) {
        List<Set<Character>> listOfCharSet = new ArrayList<>(MAX_LENGTH);
        for (int i = 0; i < MAX_LENGTH; i++) {
            listOfCharSet.add(new HashSet<>());
        }
        cleanedAdverseries.forEach(item -> {
            for (int i = 0; i < MAX_LENGTH; i++) {
                listOfCharSet.get(i).add(item.charAt(i));
            }
        });
        return listOfCharSet;
    }

}