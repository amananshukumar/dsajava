import java.util.ArrayList;

public class heap {
    static class Heap{
        ArrayList<Integer> list=new ArrayList<>();

        public void add(int data){
            list.add(data);

            int x=list.size()-1;
            int par=(x-1)/2;

            while (list.get(x)< list.get(par)) {
                int temp=list.get(x);
                list.set(x, list.get(par));
                list.set(par, temp);
                
            }
        }
        public int peek(){
            return list.get(0);
        }

        public void heapify(int idx){
            int left=2*idx+1;
            int right=2*idx+2;
            int minIdx=idx;

            if(left<list.size() && list.get(left)<list.get(minIdx)){
                minIdx=left;
            }
            if(right<list.size() && list.get(right)<list.get(minIdx)){
                minIdx=right;
            }
            if(minIdx!=idx){
                int temp=list.get(idx);
                list.set(idx, list.get(minIdx));
                list.set(minIdx, temp);
                heapify(minIdx);
            }
        }

        public  int remove(){
            int data=list.get(0);
            int temp=list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1,temp);

            list.remove(list.size()-1);
            //heapify
            heapify(0);
            return data;
            
        }

        public boolean isEmpty(){
            return list.size()==0;
        }


    }
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(40);
        h.add(50);
        h.add(60);
        h.add(70);
        h.add(80);
        h.add(90);
        h.add(100);

        while(!h.isEmpty()){
            System.out.println(h.peek());
            h.remove();
        }
    }
}
