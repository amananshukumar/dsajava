import java.util.ArrayList;
import java.util.Collections;

public class arraylist {

    public static void swap(ArrayList<Integer> list,int idx1,int idx2){
        int temp=list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
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

        //find max element
        int max=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            //if(list.get(i)>max){
            //    max=list.get(i);
           // }
            max=Math.max(max, list.get(i));
        }
        System.out.println("\nMax element: "+max);

        int idx1=1,idx2=3;
        swap(list,idx1,idx2);
        System.out.println("After swapping "+idx1+" and "+idx2+": "+list);
        //using Collections class to sort
        Collections.sort(list);
        System.out.println("After sorting: "+list);

        //descending order
        Collections.sort(list,Collections.reverseOrder());
        System.out.println("After sorting in descending order: "+list);

        //2D ArrayList
        ArrayList<ArrayList<Integer>> mainList=new ArrayList<>();
        ArrayList<Integer> listA=new ArrayList<>();
        listA.add(1);
        listA.add(2);
        ArrayList<Integer> listB=new ArrayList<>();
        listB.add(3);
        listB.add(4);
        mainList.add(listA);
        mainList.add(listB);

        for(int i=0;i<mainList.size();i++){
            ArrayList<Integer> currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);
    }

}
