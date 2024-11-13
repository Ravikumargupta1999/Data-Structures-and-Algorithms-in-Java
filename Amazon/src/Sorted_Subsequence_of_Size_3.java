import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon
// https://www.youtube.com/watch?v=HWQINGgy0kA

public class Sorted_Subsequence_of_Size_3 {
    static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        if (n < 3)
            return new ArrayList<>();
        if (n == 3) {
            if (arr.get(0) < arr.get(1) && arr.get(1) < arr.get(2)) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr.get(0));
                al.add(arr.get(1));
                al.add(arr.get(2));
                return al;
            }
            return new ArrayList<>();
        }
        int min = 0;
        int max = n - 1;
        int[] mina = new int[n];
        int[] maxa = new int[n];

        mina[0] = -1;
        maxa[n - 1] = -1;
        for (int i = 1; i < n; i++) {
            if (arr.get(i) <= arr.get(min)) {
                min = i;
                mina[i] = -1;
            } else {
                mina[i] = min;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(max)) {
                max = i;
                maxa[i] = -1;
            } else {
                maxa[i] = max;
            }
        }
        for (int i = 0; i < n; i++) {
            if (mina[i] != -1 && maxa[i] != -1) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(arr.get(mina[i]));
                al.add(arr.get(i));
                al.add(arr.get(maxa[i]));
                return al;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int n = 14;
        int[] arr = {58, 15, 44, 54, 36, 33, 93, 7, 18, 69, 30, 39, 60, 51};
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            al.add(arr[i]);
        System.out.println(find3Numbers(al, args.length));
    }
}
