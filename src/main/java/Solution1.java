import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Solution1 {

    public static void main(String[] args) throws IOException {
        int r = 2;
        int c = 5;
        int totalMoves = r * c;
        char[][] grid = new char[r + 1][c + 1];
        Set<String> moves = new HashSet<>();
        int lastI = r;
        int lastJ = c - c / 2;
        grid[lastI][lastJ] = 'x';
        int i = lastI;
        int j = lastJ;
        int count = 0;
        if (r % 2 == 0 && c % 2 == 0) {
            System.out.println("IMPOSSIBLE");
        }
        while (count <= totalMoves) {
            if (grid[i][j] != 'x' && !moves.contains(i + " " + j) && i != lastI && j != lastJ && (i - j) != (lastI = lastJ) && (i + j) != (lastI + lastJ)) {
                grid[i][j] = 'x';
                lastI = i;
                lastJ = j;
                count++;
                moves.add(i + " " + j);
            }
            i = (int) (Math.random() * r + 1);
            j = (int) (Math.random() * c + 1);

        }
        System.out.println("POSSIBLE");
        moves.forEach(item -> System.out.println(item));
    }

}