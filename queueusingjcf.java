import java.util.*;
public class queueusingjcf {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        q.add(110);
        q.add(120);
        q.add(130);

        while (!q.isEmpty()) {
            System.out.println(q.remove());     
        }
    
}
}
