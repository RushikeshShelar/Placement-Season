package recursion.Questions;

// 17. Letter Combinations of a Phone Number
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;

public class LetterCombinations {
    public static void main(String[] args) {
        combinations("", "23");

//        System.out.println(combinationsArrOG("", "2"));
        System.out.println(combinationsCount("", "2345"));
    }


    static void combinations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        int digit = unProcessed.charAt(0) - '0'; // this will convert '2'(char) into 2(int)

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char characterToAdd = (char) ('a' + i);

            combinations(processed + characterToAdd, unProcessed.substring(1));
        }
    }

    static ArrayList<String> combinationsArrOG(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unProcessed.charAt(0) - '0'; // this will convert '2'(char) into 2(int)

        if (digit == 1) {
            return combinationsArrOG(processed, unProcessed.substring(1));
        }

        ArrayList<String> ans = new ArrayList<>();

        for (int i = (digit - 2) * 3; i < digit * 3 - 3; i++) {
            char characterToAdd = (char) ('a' + i);

            ans.addAll(combinationsArrOG(processed + characterToAdd, unProcessed.substring(1)));
        }

        return ans;
    }

    static int combinationsCount(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            return 1;
        }

        int digit = unProcessed.charAt(0) - '0'; // this will convert '2'(char) into 2(int)

        int count = 0;

        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char characterToAdd = (char) ('a' + i);

            count += combinationsCount(processed + characterToAdd, unProcessed.substring(1));
        }

        return count;
    }


}

//    Actual LEETCODE SOLUTION WITHOUT SEEING
class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            return list;
        }
        return combinations("", digits);
    }

    static ArrayList<String> combinations(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int digit = unProcessed.charAt(0) - '0'; // this will convert '2'(char) into 2(int)

        if (digit == 1) {
            return combinations(processed, unProcessed.substring(1));
        }

        ArrayList<String> ans = new ArrayList<>();

        int startRange = (digit >= 8) ? (digit - 2) * 3 + 1 : (digit - 2) * 3;
        int endRange = (digit == 7 || digit == 9) ? startRange + 4 : startRange + 3;

        for (int i = startRange; i < endRange; i++) {
            char characterToAdd = (char) ('a' + i);

            ans.addAll(combinations(processed + characterToAdd, unProcessed.substring(1)));
        }
        return ans;
    }
}