import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//https://practice.geeksforgeeks.org/problems/lru-cache/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&category[]=Hash&query=company[]Amazondifficulty[]1page1company[]Amazoncategory[]Hash#

public class LRUCache {
    static LinkedHashMap<Integer, Integer> map;
    static int CAPACITY;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    // This method works in O(1)
    public static int get(int key) {
        // System.out.println("Going to get the value " +
        //                       "for the key : " + key);
        return map.getOrDefault(key, -1);
    }

    // This method works in O(1)
    public static void set(int key, int value) {
        // System.out.println("Going to set the (key, " +
        //      "value) : (" + key + ", " + value + ")");
        map.put(key, value);
    }

    public static void main(String[] args) {
//        LRUCache
        LRUCache a = new LRUCache(2);
        set(1, 2);
        System.out.println(map);

        set(2, 3);
        System.out.println(map);

        set(1, 5);
        System.out.println(map);

        set(4, 5);
        System.out.println(map);

        set(6, 7);
        System.out.println(map);

        System.out.println(get(4));
        System.out.println(map);

        set(1, 2);
        System.out.println(map);


        System.out.println(get(3));
        System.out.println(map);
    }
}
//cap = 2
//        Q = 8
//        Queries = SET 1 2 SET 2 3 SET 1 5
//        SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3