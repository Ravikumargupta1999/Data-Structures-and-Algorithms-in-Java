import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//https://leetcode.com/problems/insert-delete-getrandom-o1/
public class Video_55_Insert_Delete_GetRandom {
}

class RandomizedSet {

    HashMap<Integer, Integer> map;
    List<Integer> list;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        map.remove(val);
        if (index == list.size() - 1) {
            list.remove(list.size() - 1);
            return true;
        }
        list.set(index, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        map.put(list.get(index), index);
        return true;
    }

    public int getRandom() {
        int randomIdx = r.nextInt(list.size());
        return list.get(randomIdx);
    }
}
