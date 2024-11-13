import java.util.ArrayList;
//Done
public class Array11_Union_Of_two_Sorted_Arrays {
    // https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1
    public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        ArrayList<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if (al.size() != 0 && al.get(al.size() - 1) == arr1[i]) {
                    i++;
                    j++;
                } else {
                    al.add(arr1[i++]);
                    j++;
                }

            } else if (arr1[i] < arr2[j]) {
                if (al.size() != 0 && al.get(al.size() - 1) == arr1[i])
                    i++;
                else
                    al.add(arr1[i++]);
            } else {
                if (al.size() != 0 && al.get(al.size() - 1) == arr2[j])
                    j++;
                else {
                    al.add(arr2[j++]);
                }
            }

        }
        while (i < n) {
            if (al.size() != 0 && al.get(al.size() - 1) == arr1[i])
                i++;
            else {
                if (al.size() != 0 && al.get(al.size() - 1) == arr1[i])
                    i++;
                else
                    al.add(arr1[i++]);
            }
        }

        while (j < m) {
            if (al.size() != 0 && al.get(al.size() - 1) == arr2[j])
                j++;
            else {
                if (al.size() != 0 && al.get(al.size() - 1) == arr2[j])
                    j++;
                else {
                    al.add(arr2[j++]);
                }
            }
        }

        return al;
    }
}
