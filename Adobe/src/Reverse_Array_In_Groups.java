import java.util.*;
// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1/?page=3&company[]=Adobe&sortBy=submissions

public class Reverse_Array_In_Groups {
    // 0 - 3
    // 4 - 6
    // 7 - 8
    void reverseInGroups(ArrayList<Integer> arr, int n, int k) {

        for (int i = 0; i < n; i += k) {
            reverse(arr, i, i + k-1);
        }
    }

    void reverse(ArrayList<Integer> al, int l, int r) {
        r = r >= al.size() ? al.size() - 1 : r;
        while (l < r) {
            int temp = al.get(r);
            al.set(r, al.get(l));
            al.set(l, temp);
            l++;
            r--;
        }
        return;
    }

    public static void main(String[] args) {

    }
}
