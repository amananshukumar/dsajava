import java.util.*;
public class duplicateparenthesis {
    public static boolean duplicateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch==')'){
                int count=0;
                while(stack.peek()!='('){
                    stack.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "((a+b))";
        System.out.println(duplicateParenthesis(str));

    }
}
