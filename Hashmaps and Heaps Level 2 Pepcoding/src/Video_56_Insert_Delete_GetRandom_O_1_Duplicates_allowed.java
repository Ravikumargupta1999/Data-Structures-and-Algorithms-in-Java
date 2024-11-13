import java.util.*;
// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/submissions/
public class Video_56_Insert_Delete_GetRandom_O_1_Duplicates_allowed {
}

class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    Random r;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        boolean flag = false;
        HashSet<Integer> set;
        if (map.containsKey(val)) {
            set = map.get(val);
            flag = false;
        } else {
            set = new HashSet<>();
            flag = true;
        }
        set.add(list.size());
        list.add(val);
        map.put(val, set);
        return flag;
    }

    public boolean remove(int val) {
        HashSet<Integer> set;
        if (!map.containsKey(val))
            return false;
        set = map.get(val);
        int remidx = -1;
        for (int i : set) {
            remidx = i;
            break;
        }
        set.remove(remidx);
        map.put(val, set);
        if (map.get(val).size() == 0)
            map.remove(val);
        if (remidx == list.size() - 1)
            list.remove(list.size() - 1);
        else {
            list.set(remidx, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            int newVal = list.get(remidx);
            HashSet<Integer> temp = map.get(newVal);
            temp.remove(list.size());
            temp.add(remidx);
            map.put(newVal, temp);
        }
        return true;

    }

    public int getRandom() {
        int remIdx = r.nextInt(list.size());
        return list.get(remIdx);
    }
}