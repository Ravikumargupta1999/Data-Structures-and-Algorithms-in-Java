import java.util.ArrayList;

public class Backtracking_293_Kth_Permutation_Sequence_of_first_N_natural_numbers {
    // https://leetcode.com/problems/permutation-sequence/
    // Brute Force Approach
    int k;
    String ans;
    public String getPermutation(int n, int m) {
        String str = "";
        k = m;
        for (int i = 1; i <= n; i++)
            str += "" + i;
        findPermutation(str, "");
        return ans;
    }

    public void findPermutation(String str, String asf) {
        if (k < 0)
            return;
        if (str.length() == 0) {
            k--;
            if (k == 0) {
                ans = asf;
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            findPermutation(left + right, asf + str.charAt(i));
        }
    }

    // Efficient Approach
    // https://leetcode.com/problems/permutation-sequence/submissions/
    // https://www.youtube.com/watch?v=wT7gcXLYoao&t=315s
    // https://practice.geeksforgeeks.org/problems/find-kth-permutation/0/?page=1&sortBy=newest&query=page1sortBynewest
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
