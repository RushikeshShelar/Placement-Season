package StackQueues.stack;

public class StackMain {
    public static void main(String[] args) throws StackException {
        CustomStack stack = new CustomStack(5);

        stack.push(34);
        stack.push(25);
        stack.push(56);
        stack.push(10);
        stack.push(11);
//        stack.push(33);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
