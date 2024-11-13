import java.util.*;

public class Weekly_Contest_310 {

    // https://leetcode.com/contest/weekly-contest-310/
        public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int e : nums)
            map.put(e, map.getOrDefault(e, 0) + 1);
        int res = -1;
        int count = 0;


        // using for-each loop for iteration over Map.entrySet()
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (key % 2 == 0) {
                if (value > key) {
                    res = key;
                    count = value;
                } else if (value == key) {
                    if (key < value) {
                        value = key;
                    }
                }
            }
        }
        return res;
    }

    static int longestSubsequence(int k, int arr[]) {
        int n = arr.length;
        int lis[] = new int[n];
        int i, j, max = 0;
        for (i = 0; i < n; i++)
            lis[i] = 1;
        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1 && arr[i] - arr[j] >= k)
                    lis[i] = lis[j] + 1;

        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }


    // https://leetcode.com/contest/weekly-contest-310/problems/divide-intervals-into-minimum-number-of-groups/
    // same as minimum platform
    public int minGroups(int[][] intervals) {
        int[] ari = new int[intervals.length];
        int[] dep = new int[intervals.length];
        int k=0;
        int n = intervals.length;
        for (int[] a : intervals){
            ari[k] = a[0];
            dep[k]= a[1];
            k++;
        }
        Arrays.sort(ari);
        Arrays.sort(dep);
        int pf = 1;
        int max = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (dep[j] >= ari[i]) {
                i++;
                pf++;
                max = Math.max(pf, max);
            } else {
                pf--;
                j++;
            }
        }
        return max;
    }


    // https://leetcode.com/contest/weekly-contest-310/problems/optimal-partition-of-string/
    int min;
    public int partitionString1(String s) {
        min = s.length() + 1;
        int[] arr = new int[26];
        arr[s.charAt(0) - 'a']++;
        getMin(s, arr, 1, 1);
        return min;
    }

    public void getMin(String s, int[] arr, int index, int count) {
        if (index == s.length()) {
            min = Math.min(min, count);
            return;
        }
        if (arr[s.charAt(index) - 'a'] == 0) {
            arr[s.charAt(index) - 'a']++;
            getMin(s, arr, index + 1, count);
            arr[s.charAt(index) - 'a']--;
        }
        int[] newArr = new int[26];
        newArr[s.charAt(index) - 'a']++;
        getMin(s, newArr, index + 1, count + 1);
        newArr[s.charAt(index) - 'a']--;
    }

    //    Optimal Partition of String
    // https://leetcode.com/contest/weekly-contest-310/problems/optimal-partition-of-string/
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                set = new HashSet<>();
                set.add(ch);
                count++;
            } else {
                set.add(ch);
            }
        }
        return count;
    }
}
