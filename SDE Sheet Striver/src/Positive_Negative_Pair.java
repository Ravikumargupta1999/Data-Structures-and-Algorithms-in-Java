import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/positive-negative-pair5209/1?page=18&company[]=Amazon&sortBy=submissions
public class Positive_Negative_Pair {
    public static ArrayList<Integer> findPairs(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : arr) {
            if (set.contains(-ele)) {
                if (ele < 0) {
                    list.add(ele);
                    list.add(-ele);
                } else {
                    list.add(-ele);
                    list.add(ele);
                }
            }
            set.add(ele);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{1,3,6,-2,-1,-3,2,7},2));
    }
}
