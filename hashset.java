import java.util.Iterator;

public class hashset {
    public static void main(String[] args) {
        java.util.HashSet<String> hs = new java.util.HashSet<String>();
        hs.add("a");
        hs.add("b");
        hs.add("c");
        hs.add("d");
        hs.add("e");
        hs.add("f");
        hs.add("g");
        hs.add("h");
        hs.add("i");
        // Iterator it = hs.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());
       //}
        for (String i : hs) {
            System.out.println(i);
            
        }
    } 
}
