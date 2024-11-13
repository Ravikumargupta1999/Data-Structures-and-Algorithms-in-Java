import java.util.ArrayList;
import java.util.List;


// https://practice.geeksforgeeks.org/problems/next-greater-number-set-digits3503/1
// Next Permutation
//https://www.youtube.com/watch?v=LuLCLgMElus
//https://leetcode.com/problems/next-permutation/
//https://practice.geeksforgeeks.org/problems/next-permutation5226/1

public class Practice_19_Next_greater_number_set_digits {
    public static int findNext(int n) {
        int digit = noOfDigit(n, 10);
        int[] arr = new int[digit];
        int temp = n;
        int k = digit - 1;
        while (temp > 0) {
            arr[k--] = temp % 10;
            temp = temp / 10;
        }
//        System.out.println(Arrays.toString(arr));
        List<Integer> al = nextPermutation(digit, arr);
//        System.out.println(al);
        int i = 0;
        temp = 0;
        while (i < al.size()) {
            temp = al.get(i) + temp*10 ;
//            System.out.println(temp);
            i++;
        }
        if(temp == n)
            return -1;
        return temp;
    }

    public static int noOfDigit(int n, int b) {
        return (int) (Math.log(n) / Math.log(b)) + 1;
    }

    static List<Integer> nextPermutation(int n, int arr[]) {
        int index = -1;
        int i = arr.length - 2;
        while (i >= 0 && arr[i] >= arr[i + 1])
            i--;
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i])
                j--;
            swap(arr, i, j);
        }
        else if(index == -1)
        {
            List<Integer> al = new ArrayList<>();
            for (int l = 0; l < arr.length; l++) {
                al.add(arr[l]);
            }
            return al;
        }
        reverse(arr, i + 1, arr.length - 1);
        List<Integer> al = new ArrayList<>();
        for (int l = 0; l < arr.length; l++) {
            al.add(arr[l]);
        }
//        System.out.println(Arrays.toString(arr));
        return al;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j)
            swap(arr, i++, j--);
    }

    public static void main(String[] args) {
        System.out.println(findNext(321));
    }
}
