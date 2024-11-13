import java.util.*;

// https://practice.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
public class Practice_11_All_Unique_Permutations_of_an_array {


    // Method - 1
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> al, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = al.get(i);
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        permutation(arr, 0, ans);
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i)) return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });
        return ans;
    }

    static void permutation(int[] arr, int ind, ArrayList<ArrayList<Integer>> ans) {
        if (ind == arr.length - 1) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                al.add(arr[i]);
            ans.add(al);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = ind; i < arr.length; i++) {
            if (set.contains(arr[i]))
                continue;
            int temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
            permutation(arr, ind + 1, ans);
            temp = arr[i];
            arr[i] = arr[ind];
            arr[ind] = temp;
            set.add(arr[i]);
        }
    }

    // Method - 2
    static ArrayList<ArrayList<Integer>> uniquePermutations(ArrayList<Integer> arr, int n) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        getAllUniquePermutations(n, map, new ArrayList<>(), result);

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i)) return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });
        return result;
    }

    static void getAllUniquePermutations(int n, HashMap<Integer, Integer> map, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result) {
        if (temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                temp.add(key);
                map.put(key, map.get(key) - 1);
                getAllUniquePermutations(n, map, temp, result);
                temp.remove(temp.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
}
