package InterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;

public class Video_52_Sorted_Subsequence_Of_Size_3 {
    // https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1
    static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = n - 1; i >= 2; i--) {
            list.add(arr.get(i));
            if (findSubsequence(i, arr, list)) {
                Collections.reverse(list);
                return list;
            }
            list.remove(list.size() - 1);
        }
        return new ArrayList<>();
    }

    static boolean findSubsequence(int index, ArrayList<Integer> arr, ArrayList<Integer> list) {
        if (list.size() >= 3)
            return true;
        else if (index < 0)
            return false;
        for (int i = index - 1; i >= 0; i--) {
            if (arr.get(i) < list.get(list.size() - 1)) {
                list.add(arr.get(i));
                if (findSubsequence(i, arr, list))
                    return true;
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3};
        ArrayList<Integer> list = new ArrayList<>();
        for (int ele : arr)
            list.add(ele);
        System.out.println(find3Numbers(list, list.size()));
    }

    // Iterative Solution
    ArrayList<Integer> find3Numbers1(ArrayList<Integer> arr, int n) {
        if (n < 3)
            return new ArrayList<>();
        if (n == 3) {
            if (arr.get(0) < arr.get(1) && arr.get(1) < arr.get(2)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr.get(0));
                al.add(arr.get(1));
                al.add(arr.get(2));
                return al;
            }
            return new ArrayList<>();
        }
        int min = 0;
        int max = n - 1;
        int[] minArray = new int[n];
        int[] maxArray = new int[n];

        minArray[0] = -1;
        maxArray[n - 1] = -1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)) {
                min = i;
                minArray[i] = -1;
            } else {
                minArray[i] = min;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(max)) {
                max = i;
                maxArray[i] = -1;
            } else {
                maxArray[i] = max;
            }
        }
        for (int i = 0; i < n; i++) {
            if (minArray[i] != -1 && maxArray[i] != -1) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr.get(minArray[i]));
                al.add(arr.get(i));
                al.add(arr.get(maxArray[i]));
                return al;
            }
        }
        return new ArrayList<>();
    }

}
