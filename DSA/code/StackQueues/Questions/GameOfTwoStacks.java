package StackQueues.Questions;


//https://www.hackerrank.com/challenges/game-of-two-stacks/

import java.util.Arrays;
import java.util.List;

public class GameOfTwoStacks {

    //    USing ARRAYS
    public static int twoStacksArr(int maxSum, int[] a, int[] b) {
        // Write your code here
        return twoStacksArr(maxSum, a, b, 0, 0) - 1;
    }


    private static int twoStacksArr(int maxSum, int[] a, int[] b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        if (a.length == 0 || b.length == 0) {
            return count;
        }

//      Left Side Call in Recursion Picking Element from array a
        int ans1 = twoStacksArr(maxSum, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);

//     Right Side Call in Recursion Picking Element from array b
        int ans2 = twoStacksArr(maxSum, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

        return Math.max(ans1, ans2);
    }


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        return twoStacks(maxSum, a, b, 0, 0);
    }


    private static int twoStacks(int maxSum, List<Integer> a, List<Integer> b, int sum, int count) {
        if (sum > maxSum) {
            return count;
        }

        if (a.isEmpty() || b.isEmpty()) {
            return count;
        }

//      Left Side Call in Recursion Picking Element from array a
        int ans1 = twoStacks(maxSum, a.subList(1, a.size()), b, sum + a.get(0), count + 1);

//     Right Side Call in Recursion Picking Element from array b
        int ans2 = twoStacks(maxSum, a, b.subList(1, b.size()), sum + b.get(0), count + 1);

        return Math.max(ans1, ans2);
    }

    //    Iterative approcah that was Submitted SuccessFully (SINCE RECURSIVE APPROACH GIVE TLE ERROR)
    public static int twoStacksITR(int maxSum, List<Integer> a, List<Integer> b) {
        int sum = 0, count = 0, i = 0, j = 0;

        // Take as many elements as possible from stack 'a' first
        while (i < a.size() && sum + a.get(i) <= maxSum) {
            sum += a.get(i);
            i++;
        }

        // The initial count is the number of elements taken from 'a'
        count = i;

        // Now try to add elements from 'b' while reducing from 'a'
        while (j < b.size() && i >= 0) {
            sum += b.get(j);
            j++;

            // If the sum exceeds maxSum, remove elements from 'a'
            while (sum > maxSum && i > 0) {
                i--;
                sum -= a.get(i);
            }

            // Update the count if the current number of elements is better
            if (sum <= maxSum) {
                count = Math.max(count, i + j);
            }
        }

        return count;
    }

}
