package Day_9_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {
    // https://leetcode.com/problems/permutation-sequence/submissions/
    public static void main(String[] args) {
        System.out.println(getPermutation(9, 78494));
    }

    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        boolean[] arr = new boolean[n + 1];
        generatePermutation(arr, 0, n, "", list);
        System.out.println(list);
        return list.get(k - 1);
    }

    public static void generatePermutation(boolean[] arr, int used, int n, String str, List<String> list) {
        if (used == n) {
            list.add(str);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                arr[i] = true;
                generatePermutation(arr, used + 1, n, str + "" + i, list);
                arr[i] = false;
            }
        }
    }
    // https://www.youtube.com/watch?v=wT7gcXLYoao&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=56
    public String getPermutation1(int n, int k) {
        int fact = 1;
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            al.add(i);
        }
        al.add(n);
        String ans = "";
        k = k - 1;
        while (true) {
            ans = ans + al.get(k / fact);
            al.remove(k / fact);
            if (al.size() == 0)
                break;
            k = k % fact;
            fact = fact / al.size();
        }
        return ans;
    }
}
