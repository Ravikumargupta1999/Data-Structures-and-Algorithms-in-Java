package Day3;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // https://leetcode.com/problems/combinations/submissions/
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombination(1, n, k, list, res);
        return res;
    }

    public void getCombination(int val, int n, int k, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (val > n || temp.size() > k)
            return;

        for (int v = val; v <= n; v++) {
            temp.add(v);
            getCombination(v+1,n,k,temp,res);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4,3));
    }

}
