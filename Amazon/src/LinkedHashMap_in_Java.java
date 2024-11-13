import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMap_in_Java {
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(2, 3);
        map.put(5, 8);
        map.put(1, 3);

        for (Map.Entry<Integer, Integer> mapElement : map.entrySet()) {

            Integer key = mapElement.getKey();

            // Finding the value
            Integer value = mapElement.getValue();

            // print the key : value pair
            System.out.println(key + " : " + value);
        }
        System.out.println(map.size());
    }
}
