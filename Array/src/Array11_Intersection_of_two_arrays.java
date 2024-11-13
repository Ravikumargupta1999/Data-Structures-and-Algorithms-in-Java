import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//Done
public class Array11_Intersection_of_two_arrays {
    // https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1
    public static int numberOfElementsInIntersection(int[] a, int[] b, int n, int m) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int val : a)
            set1.add(val);

        HashSet<Integer> set2 = new HashSet<>();
        for (int val : b)
            set2.add(val);


        int count = 0;
        for (int val : set1) {
            if (set2.contains(val))
                count++;
        }
        return count;

    }

    // https://leetcode.com/problems/intersection-of-two-arrays/
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int val : nums1)
            set1.add(val);

        HashSet<Integer> set2 = new HashSet<>();
        for (int val : nums2)
            set2.add(val);


        int count = 0;
        for (int val : set1) {
            if (set2.contains(val))
                count++;
        }
        int[] ans = new int[count];


        count = 0;
        for (int val : set1) {
            if (set2.contains(val))
                ans[count++] = val;
        }
        return ans;
    }
    // https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/864590053/
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] arr = new int[list.size()];

        i = 0;
        for (int val : list)
            arr[i++] = val;
        return arr;
    }
}
