import java.util.*;
public class priorityQueue {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(10);
        pq.add(20);
        pq.add(30);
        pq.add(5);
        pq.add(15);
        pq.add(25);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }

        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student("a", 10));
        pq2.add(new Student("b", 20));
        pq2.add(new Student("c", 30));
        pq2.add(new Student("d", 5));
        pq2.add(new Student("e", 15));
        pq2.add(new Student("f", 25));
        while (!pq2.isEmpty()) {
            System.out.println(pq2.peek().name + " " + pq2.peek().rank);
        }
    }
    
}