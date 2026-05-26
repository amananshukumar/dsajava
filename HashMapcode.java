import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class HashMapcode {
    static class HashMap<K,V> {
        private class Node {
            K key;
            V value;
            Node next;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }   
        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }   

        private int SearchInLL(K key,int bi) {
            LinkedList<Node> ll = this.buckets[bi];
            int di=0;
            for (int i=0;i<ll.size();i++) {
                Node node = ll.get(i);
                if(node.key.equals(key)) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuckets[] = this.buckets;
            buckets = new LinkedList[N*2];
            N=N*2;
            for(int i=0; i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashfunction(key);
            int di=SearchInLL(key,bi);

            if(di !=-1){
                Node node = buckets[bi].get(di);
                node.value=value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            double lambda=(double)n/N;
            if(lambda>2.0){
                rehash();
            }

        }

        private int hashfunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }

        public boolean comtainsKey(K key){
            int bi = hashfunction(key);
            int di=SearchInLL(key,bi);
            if(di==-1){
                return false;
            }else{
                return true;
            }
        }

        public V get(K key){
            int bi = hashfunction(key);
            int di=SearchInLL(key,bi);
            if(di==-1){
                return null;
            }else{
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public V remove(K key){
            int bi = hashfunction(key);
            int di=SearchInLL(key,bi);
            if(di!=-1){
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
               return null;
            }
        }

        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

        public static void main(String[] args) {
            HashMap<String, Integer> map = new HashMap<>();
            map.put("A", 1);
            map.put("B", 2);
            map.put("C", 3);
            map.put("D", 4);

            ArrayList<String> keys = map.keyset();
            for (String key : keys) {
                System.out.println(key + " " + map.get(key));
            }
        }

    }
}
