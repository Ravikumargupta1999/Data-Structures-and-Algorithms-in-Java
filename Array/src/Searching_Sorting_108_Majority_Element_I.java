import java.util.Scanner;


// Done
public class Searching_Sorting_108_Majority_Element_I {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        int value = majorityElement(arr);
        System.out.println(value);
    }

    // https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
    // https://leetcode.com/problems/majority-element/submissions/
    public static int majorityElement(int[] arr) {
        int ans = 0;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[ans])
                count++;
            else
                count--;
            if (count == 0) {
                ans = i;
                count = 1;
            }
        }
        count = 0;
        int element = arr[ans];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element)
                count++;
        }
//        System.out.println(count);
        if (count > arr.length / 2)
            return arr[ans];
        else
            return -1;

    }
}
