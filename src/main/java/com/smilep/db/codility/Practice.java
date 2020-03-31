package com.smilep.db.codility;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {
        int[] input = new int[] { -1, -2, -3, -3, 1,3 };
        System.out.println(solution(input));
    }

    public static int solution(int[] A) {
        int result = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            int j = A[i];
            if (j < 0) {
                continue;
            }
            if (i == 0 || j != A[i - 1]) {
                result++;
            }
            if (result != j) {
                break;
            }
            if (i == A.length - 1) {
                result++;
            }
        }
        if (result == 0) {
            result = 1;
        }
        return result;
    }

}
