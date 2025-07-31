package main.java;

import java.util.Stack;

public class WorkingWithStacks {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // The element at the top of the stack
        System.out.println(stack.size()); // Return the number of components in this vector
        System.out.println(stack.pop());
        System.out.println(stack.size()); //

        System.out.println(stack.empty()); // Returns true if the stack is empty
    }
}
