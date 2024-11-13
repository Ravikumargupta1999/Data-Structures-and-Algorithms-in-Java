import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Video_2_Union_of_two_arrays {

    // https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
    // HashSet Solution
    public static int doUnion(int[] a, int n, int[] b, int m) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(a[i]);
        for (int i = 0; i < n; i++)
            set.add(b[i]);
        return set.size();
    }

    // Comparison
    public static int doUnion1(int[] a, int n, int[] b, int m) {
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n || j < m) {
            if (i < n && j < m) {
                if (a[i] < b[j]) {
                    if (al.size() != 0) {
                        if (al.get(al.size() - 1) != a[i])
                            al.add(a[i]);
                        i++;
                    } else {
                        al.add(a[i]);
                        i++;
                    }
                } else if (a[i] > b[j]) {
                    if (al.size() != 0) {
                        if (al.get(al.size() - 1) != b[j])
                            al.add(b[j]);
                        j++;

                    } else {
                        al.add(b[j]);
                        j++;
                    }
                } else if (a[i] == b[j]) {
                    if (al.size() != 0) {
                        if (al.get(al.size() - 1) != b[j])
                            al.add(b[j]);
                        j++;
                        i++;

                    } else {
                        al.add(b[j]);
                        j++;
                        i++;
                    }
                }
            } else if (i < n) {
                if (al.size() != 0) {
                    if (al.get(al.size() - 1) != a[i])
                        al.add(a[i]);
                    i++;
                } else {
                    al.add(a[i]);
                    i++;
                }
            } else if (j < m) {
                if (al.size() != 0) {
                    if (al.get(al.size() - 1) != b[j])
                        al.add(b[j]);
                    j++;

                } else {
                    al.add(b[j]);
                    j++;
                }

            }
        }
        return al.size();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3};
        System.out.println(doUnion1(arr1, arr1.length, arr2, arr2.length));
    }

}
