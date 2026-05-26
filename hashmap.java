import java.util.HashMap;
import java.util.Set;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);


        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        }
        
        System.out.println(map);

        map.get("A");
        System.out.println(map.containsKey("h"));
        System.out.println(map.containsValue(4));
        System.out.println(map.remove("B"));
        System.out.println(map.size());
    }
}
