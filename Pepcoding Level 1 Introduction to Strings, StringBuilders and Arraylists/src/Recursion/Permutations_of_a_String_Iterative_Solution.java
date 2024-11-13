package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations_of_a_String_Iterative_Solution {
    public static void main(String[] args) {
        System.out.println(find_permutation("abc"));
    }

    public static List<String> find_permutation(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        int f = factorial(n);
        for (int i = 0; i < f; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder(s);
            StringBuilder ans = new StringBuilder();
            for (int div = n; div >= 1; div--) {
                int q = temp / div;
                int r = temp % div;
                ans.append(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            result.add(ans.toString());
        }
        Collections.sort(result);
        return result;
    }
    public static int factorial(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++)
            ans *= i;
        return ans;
    }
}
