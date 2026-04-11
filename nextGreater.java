import java.util.*;

public class nextGreater {
    public static void main(String[] args) {
        int arr[] = {6, 8, 9, 5};
        Stack<Integer> stack = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
    }
}