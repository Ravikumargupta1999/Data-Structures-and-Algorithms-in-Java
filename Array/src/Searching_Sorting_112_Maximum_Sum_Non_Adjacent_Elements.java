import java.util.ArrayList;

public class Searching_Sorting_112_Maximum_Sum_Non_Adjacent_Elements {

    // https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
    // https://www.youtube.com/watch?v=VT4bZV24QNo
    // Recursion
    public int FindMaxSum(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        findMaximumNonAdjacentSum(0, false, arr, 0, list);

        return list.get(0);
    }

    public void findMaximumNonAdjacentSum(int index, boolean decision, int[] arr, int sum, ArrayList<Integer> list) {
        if (index == arr.length) {
            list.set(0, Math.max(list.get(0), sum));
            return;
        }
        if (decision) {
            findMaximumNonAdjacentSum(index + 1, false, arr, sum, list);
        } else {
            findMaximumNonAdjacentSum(index + 1, true, arr, sum + arr[index], list);
            findMaximumNonAdjacentSum(index + 1, false, arr, sum, list);
        }
    }

    // https://leetcode.com/problems/house-robber/
    public int rob(int[] arr) {
        int inc = arr[0];
        int exc = 0;
        for(int i= 1;i<arr.length;i++)
        {
            int ninc = exc + arr[i];
            int nexc = Math.max(inc,exc);
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    }
}
