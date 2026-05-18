public class queueusingll {

    public static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class queue {
        static node head = null;
        static node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            node newNode = new node(data);

            if (isEmpty()) {
                head = tail = newNode;
                return;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }

            int front = head.data;
            head = head.next;

            if (head == null) {
                tail = null;
            }

            return front;
        }
    }

    public static void main(String[] args) {

        queue q = new queue();

        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}