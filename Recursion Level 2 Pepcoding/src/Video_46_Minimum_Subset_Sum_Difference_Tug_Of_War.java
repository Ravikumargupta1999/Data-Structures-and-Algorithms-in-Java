import java.util.ArrayList;
import java.util.Scanner;

public class Video_46_Minimum_Subset_Sum_Difference_Tug_Of_War {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
        System.out.println(ans);
    }

    static int minDiff = Integer.MAX_VALUE;
    static String ans = "";

    public static void solve(int[] arr, int vIdx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soSet1, int soSet2) {
        if (vIdx == arr.length) {
            int delta = Math.abs(soSet1 - soSet2);
            if (delta < minDiff) {
                minDiff = delta;
                ans = set1 + " " + set2;
            }
            return;
        }
        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[vIdx]);
            solve(arr, vIdx + 1, set1, set2, soSet1 + arr[vIdx], soSet2);
            set1.remove(set1.size() - 1);
        }
        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[vIdx]);
            solve(arr, vIdx + 1, set1, set2, soSet1, soSet2 + arr[vIdx]);
            set2.remove(set2.size() - 1);
        }


    }
}
