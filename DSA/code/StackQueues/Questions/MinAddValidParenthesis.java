package StackQueues.Questions;


//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

import java.util.Stack;

public class MinAddValidParenthesis {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("())"));

    }

    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '('){
                stack.push(ch);
            } else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }

        return stack.size();
    }
}
