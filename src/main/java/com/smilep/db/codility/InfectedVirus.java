package com.smilep.db.codility;

public class InfectedVirus {

    public static void main(String[] args) {
        int[] A = new int[] { 0, 1 };
        int[] B = new int[] { 1, 2};
        boolean[] C = new boolean[] { false, true, false };
        System.out.println(solution(A, B, C));
    }

    public static int solution(int[] A, int[] B, boolean[] C) {
        int result = -1;
        int numOfCablesCut = 0;
        for (int i = 0; i < C.length; i++) {
            boolean isInfected = C[i];
            int infectedComp = i;
            if (isInfected) {
                for (int j = 0; j < A.length; j++) {
                    if (A[j] == infectedComp) {
                        if (!C[B[j]]) {
                            numOfCablesCut++;
                            result = j;
                        }
                    }
                    if (numOfCablesCut > 1) {
                        break;
                    }
                }
                for (int j = 0; j < B.length; j++) {
                    if (B[j] == infectedComp) {
                        if (!C[A[j]]) {
                            numOfCablesCut++;
                            result = j;
                        }
                    }
                    if (numOfCablesCut > 1) {
                        break;
                    }
                }
            }
            if (numOfCablesCut > 1) {
                break;
            }
        }
        if (numOfCablesCut > 1) {
            result = -1;
        }
        return result;
    }

}
