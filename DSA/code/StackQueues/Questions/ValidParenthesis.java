package StackQueues.Questions;

//https://leetcode.com/problems/valid-parentheses/description/

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        ValidParenthesis ab = new ValidParenthesis();
        System.out.println(ab.isValid("{[]}"));
    }

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '{' || curr == '(' || curr == '[') {
                stack.push(curr);
            } else if (curr == '}' || curr == ')' || curr == ']') {

                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (curr == '}' && top != '{') {
                        return false;
                    } else if (curr == ']' && top != '[') {
                        return false;
                    } else if (curr == ')' && top != '(') {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return  false;
        }

        return true;
    }
}
