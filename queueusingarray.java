import java.util.Queue;

public class queueusingarray {
    static class queue {
        static int arr[];
        static int size ;
        static int rear;
        static int front;
        queue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
        }
        public static boolean isEmpty(){
            return rear == -1;
        }
        public static void add(int data){
            if(rear == size-1){
                return ;
            }else{
                arr[++rear] = data;
                return ;
            }
        }
        public static int remove(){
            if(rear == -1){
                return -1;
            }else{
                int ans = arr[0];
                for(int i=0;i<rear;i++){
                    arr[i] = arr[i+1];
                }
                rear--;
                return ans;
            }
        }
        
    }
}
