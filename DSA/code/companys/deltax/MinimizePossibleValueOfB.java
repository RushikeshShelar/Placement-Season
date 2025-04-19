package companys.deltax;

import java.util.Arrays;

public class MinimizePossibleValueOfB {
//    Given an array A of N positive integers and an integer M, your task is to pick M integers from A into an array B such that the function F given below gives the least possible value:
//    F(B) Max(B) - Min(B)
//    Print the lowest possible value of the given function F.

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 8, 1, 15, 20, 3};
        int M = 2;
        System.out.println(minimizeDifference(A,M));
    }

    public static int minimizeDifference(int[] A, int M) {
        int N = A.length;
        Arrays.sort(A);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= N - M; i++) {
            int currDiff = A[i + M - 1] - A[i];
            minDiff = Math.min(minDiff, currDiff);
        }

        return minDiff;
    }
}
