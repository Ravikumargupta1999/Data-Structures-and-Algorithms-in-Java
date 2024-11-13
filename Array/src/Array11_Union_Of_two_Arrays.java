import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
//Done
public class Array11_Union_Of_two_Arrays {
    // https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

    public static int doUnion(int a[], int n, int b[], int m) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.length; i++)
            map.put(a[i], 0);
        for (int i = 0; i < b.length; i++)
            map.put(b[i], 0);
        return map.size();
    }

    public static int doUnion1(int[] a, int n, int[] b, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            set.add(a[i]);
        for (int i = 0; i < b.length; i++)
            set.add(b[i]);
        return set.size();
    }

}
