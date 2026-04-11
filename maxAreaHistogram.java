import java.util.*;
public class maxAreaHistogram {
    public static void maxArea(int arr[]) {
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        s= new Stack<>();
        for(int i=0;i<arr.length;i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        //current area
        for(int i=0;i<arr.length;i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        int arr[] = {2, 4,6,7,3};
    }
}
