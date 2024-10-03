package StackQueues.Questions;

import java.util.Stack;

//https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
//For 1 ( there must be 2 ))

public class MinInsertionToBalanceParenthesisi {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    insertions++;
                }
            }
        }
        return insertions + 2 * stack.size();
    }
}

