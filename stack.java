import java.util.*;
public class stack {
    public static void reversestack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        reversestack(stack);
        pushAtBottom(stack, top);
    }
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        if (stack.isEmpty()) {
            stack.push(data);
            return;
        }
        int top = stack.pop();
        pushAtBottom(stack, data);
        stack.push(top);
    }
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        pushAtBottom(stack, 6);
        System.out.println(stack);
        reversestack(stack);
    }
}