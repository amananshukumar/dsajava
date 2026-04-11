import java.util.*;
public class stockspan {
    public static void stockspan(int stock[],int span[]){
        Stack<Integer> stack=new Stack<>();//to store index of stock
        span[0]=1;
        stack.push(0);//push first element index to stack
        for(int i=1; i<stock.length;i++){
            int currPrice=stock[i];
            while(!stack.isEmpty() && stock[stack.peek()]<=currPrice){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i]=i+1;
            }
            else{
                span[i]=i-stack.peek();
            }
            stack.push(i);
        }
        
    }
    public static void main(String[] args) {
        int stock[]={100,80,60,70,60,75,85};
        int span[]=new int[stock.length];
        stockspan(stock, span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i]+" ");
        }
    }
}
