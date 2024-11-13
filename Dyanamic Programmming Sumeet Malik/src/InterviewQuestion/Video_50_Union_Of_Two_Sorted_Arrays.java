package InterviewQuestion;

import java.util.ArrayList;

public class Video_50_Union_Of_Two_Sorted_Arrays {
    // https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {

                if (list.size() == 0)
                    list.add(arr1[i]);
                else if (arr1[i] != list.get(list.size() - 1))
                    list.add(arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {

                if (list.size() == 0)
                    list.add(arr2[j]);
                else if (arr2[j] != list.get(list.size() - 1))
                    list.add(arr2[j]);
                j++;
            } else {
                if (list.size() == 0)
                    list.add(arr1[i]);
                else if (arr1[i] != list.get(list.size() - 1))
                    list.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n){
            if (list.size() == 0)
                list.add(arr1[i]);
            else if (arr1[i] != list.get(list.size() - 1))
                list.add(arr1[i]);
            i++;
        }
        while (j < m){
            if (list.size() == 0)
                list.add(arr2[j]);
            else if (arr2[j] != list.get(list.size() - 1))
                list.add(arr2[j]);
            j++;
        }

        return list;
    }
}
