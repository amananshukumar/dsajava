import java.util.*;

public class unionintersection {
    public static void main(String[] args) {
        int arr1[]={7,3,9};
        int arr2[]={2,4,6,8};
        HashSet<Integer> hs=new HashSet<Integer>();
        //union
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }    
        for(int i=0;i<arr2.length;i++){
            hs.add(arr2[i]);
        }
        System.out.println(hs);    
        //intersection
        hs.clear();
        for(int i=0;i<arr1.length;i++){
            hs.add(arr1[i]);
        }  
        int count=0;   
        for(int i=0;i<arr2.length;i++){
            if(hs.contains(arr2[i])){
                count++;
                
                hs.remove(arr2[i]);
            }
        }    
        System.out.println(count);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    }
}
