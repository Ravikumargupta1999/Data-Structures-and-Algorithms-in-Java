import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon

public class Union_Of_Two_Array {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
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
        // System.out.println(al + "  " + i + "  " + j);
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

    public static void main(String[] args) {

        int[] arr1 = {3, 4, 5, 6, 9, 11, 14, 19, 19, 23, 25, 25, 26, 28, 37, 38, 40, 42, 46, 50};
        int[] arr2 = {10, 15, 15, 19, 21, 23, 25, 25, 28, 34, 35, 38, 48};
        System.out.println(findUnion(arr1, arr2, arr1.length, arr2.length));
    }
}
