import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);

        //get operation
        int element=list.get(1);
        System.out.println(element);

        //add element in between
        list.add(1,15);
        System.out.println(list);

        //set or update
        list.set(2,25);
        System.out.println(list);

        //delete
        list.remove(3);
        System.out.println(list);

        //size
        System.out.println(list.size());

        //contains
        System.out.println(list.contains(25));  

        //print all elements
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");  
        }
        System.out.println();

        //reverse print
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");  
        }

    }

}
