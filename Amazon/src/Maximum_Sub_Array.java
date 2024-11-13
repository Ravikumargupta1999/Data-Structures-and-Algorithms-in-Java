import org.omg.Messaging.SYNC_WITH_TRANSPORT;

//https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=3&query=category[]Arrayscompany[]Amazondifficulty[]1page3company[]Amazoncategory[]Arrays#

import java.util.ArrayList;

public class Maximum_Sub_Array {
    static ArrayList<Integer> findSubarray(int arr[], int n) {
        int max_so_far = 0, max_right_here = 0;
        int start = 0, end = 0, s = 0;
        int count = 0;
        int maxlen = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] < 0)
                count++;
        if (count == arr.length) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(-1);
            return al;
        }


        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                s = i + 1;
                max_right_here = 0;

            } else {
                max_right_here += arr[i];
            }

            if (max_right_here > max_so_far) {
                max_so_far = max_right_here;
                start = s;
                end = i;
                maxlen = i - s + 1;
            } else if (max_right_here == max_so_far && maxlen < (i - s + 1)) {
                max_so_far = max_right_here;
                start = s;
                end = i;
                maxlen = i - s + 1;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        // System.out.print("Sub Array : ");
        for (int i = start; i <= end; i++) {
            al.add(arr[i]);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {13, 0, -6, 2, 8, 3, -10, 9};
        System.out.println(findSubarray(arr, arr.length));

    }
}
