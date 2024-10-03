package StackQueues.Questions;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/submissions/1400896691/

public class ImplementQueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplementQueueUsingStack(){
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item){
        first.push(item);
    }

    public int remove() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int removed = second.pop();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    public int peek() throws Exception{
        while(!first.isEmpty()){
            second.push(first.pop());
        }
        int peek= second.peek();
        while(!second.isEmpty()){
            first.push(second.pop());
        }
        return peek;
    }

    public boolean isEmpty(){
        return first.isEmpty();
    }
}
