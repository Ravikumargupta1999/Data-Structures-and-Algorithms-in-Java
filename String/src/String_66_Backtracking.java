import java.util.*;

public class String_66_Backtracking {

    // https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
    // https://www.youtube.com/watch?v=4jY57Ehc14Y&t=1101s
    public static List<String> find_permutation(String str) {
        List<String> all = new ArrayList<>();
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            if (frequencyMap.containsKey(ch)) {
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            } else
                frequencyMap.put(ch, 1);
        }
        all = generateWords(1, str.length(), frequencyMap, "", all);
        Collections.sort(all);
        return all;

    }

    public static List<String> generateWords(int cs, int ts, HashMap<Character, Integer> frequencyMap, String str, List<String> all) {
        if (cs > ts) {
            all.add(str);
            return all;
        }
        for (char ch : frequencyMap.keySet()) {
            if (frequencyMap.get(ch) > 0) {
                frequencyMap.put(ch, frequencyMap.get(ch) - 1);
                generateWords(cs + 1, ts, frequencyMap, str + ch, all);
                frequencyMap.put(ch, frequencyMap.get(ch) + 1);
            }
        }
        return all;
    }


    //    https://leetcode.com/problems/permutations-ii/
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        permute(nums.length, temp, res, map);
        return res;
    }

    public void permute(int n, List<Integer> temp, List<List<Integer>> res, HashMap<Integer, Integer> map) {
        if (temp.size() == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                map.put(key, map.get(key) - 1);
                temp.add(key);
                permute(n, temp, res, map);
                temp.remove(temp.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
