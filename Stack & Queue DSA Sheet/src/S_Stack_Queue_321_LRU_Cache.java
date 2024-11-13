import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class S_Stack_Queue_321_LRU_Cache {

    // https://practice.geeksforgeeks.org/problems/lru-cache/1#
    class LRUCache {

        HashMap<Integer, Integer> m;
        int capacity;

        LRUCache(int capacity) {
            m = new LinkedHashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!m.containsKey(key))
                return -1;
            int t = m.get(key);
            m.remove(key);
            m.put(key, t);
            return t;
        }

        public void set(int key, int value) {
            if (m.containsKey(key)) {
                m.remove(key);
                m.put(key, value);

            } else if (m.size() == capacity) {
                Map.Entry<Integer, Integer> e = m.entrySet().iterator().next();
                int k = e.getKey();
                m.remove(k);
                m.put(key, value);
            } else
                m.put(key, value);
        }
    }
}