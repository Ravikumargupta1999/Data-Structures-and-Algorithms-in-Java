import java.util.HashMap;
// https://leetcode.com/problems/subarrays-with-k-different-integers/
public class Count_Subarrays_with_K_Different_Integers {

    public int subarraysWithKDistinct(int[] arr, int k) {
        int ans = 0;
        if (k == 1)
            return solutionforK1(arr);
        HashMap<Integer, Integer> mapb = new HashMap<>();
        HashMap<Integer, Integer> maps = new HashMap<>();
        int is = -1;
        int ib = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;
            while (ib < arr.length - 1) {
                f1 = true;
                ib++;
                int ch = arr[ib];
                mapb.put(ch, mapb.getOrDefault(ch, 0) + 1);
                if (mapb.size() == k + 1) {
                    removeInMap(mapb, ch);
                    ib--;
                    break;
                }
            }

            while (is < ib) {
                f2 = true;
                is++;
                int ch = arr[is];
                maps.put(ch, maps.getOrDefault(ch, 0) + 1);
                if (maps.size() == k) {
                    removeInMap(maps, ch);
                    is--;
                    break;
                }
            }
            while (j < is) {
                f3 = true;
                if (mapb.size() == k && maps.size() == k - 1)
                    ans += (ib - is);
                j++;
                int ch = arr[j];
                removeInMap(mapb, ch);
                removeInMap(maps, ch);
                if (mapb.size() < k || maps.size() < k - 1)
                    break;
            }
            if (f1 == false && f2 == false && f3 == false)
                break;
        }
        return ans;

    }

    int solutionforK1(int[] arr) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            while (i < arr.length - 1) {
                f1 = true;
                i++;
                int ch = arr[i];
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() == 2) {
                    removeInMap(map, ch);
                    i--;
                    break;
                }

            }
            while (j < i) {
                f2 = true;
                if (map.size() == 1)
                    ans += (i - j);
                j++;
                int ch = arr[j];
                removeInMap(map, ch);
                if (map.size() == 0) {
                    break;
                }
            }
            if (f1 == false && f2 == false)
                break;
        }
        return ans;
    }

    void removeInMap(HashMap<Integer, Integer> map, int ch) {
        if (map.get(ch) == 1)
            map.remove(ch);
        else
            map.put(ch, map.get(ch) - 1);

    }
}
