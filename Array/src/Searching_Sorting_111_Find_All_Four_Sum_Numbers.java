import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Searching_Sorting_111_Find_All_Four_Sum_Numbers {
    // Using Single function
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1])
                    continue;
                int si = j + 1;
                int ei = n - 1;
                int temp1 = si;
                int temp2 = ei;
                while (si < ei) {
                    int sum = arr[i] + arr[j] + arr[si] + arr[ei];
                    if (sum > target) {
                        ei--;
                    } else if (sum < target) {
                        si++;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[si], arr[ei])));
                        si++;
                        ei--;
                        while (si < ei && temp1 != si && arr[si] == arr[si - 1])
                            si++;
                        while (si < ei && temp2 != ei && arr[ei] == arr[ei + 1])
                            ei--;

                    }
                }
            }
        }

        return res;
    }

    public static void createRes(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> smallAns, int val) {
        for (ArrayList<Integer> sa : smallAns) {
            sa.add(0, val);
            res.add(sa);
        }
    }

    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int target, int si, int ei) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int temp1 = si;
        int temp2 = ei;
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum > target)
                ei--;
            else if (sum < target)
                si++;
            else {
                res.add(new ArrayList<>(Arrays.asList(arr[si], arr[ei])));
                si++;
                ei--;
                while (si < ei && temp1 != si && arr[si] == arr[si - 1])
                    si++;
                while (si < ei && temp2 != ei && arr[ei] == arr[ei + 1])
                    ei--;
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] arr, int target, int si, int ei) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = si; i <= ei; i++) {
            if (i != si && arr[i] == arr[i - 1])
                continue;
            ArrayList<ArrayList<Integer>> smallAns = twoSum(arr, target - arr[i], i + 1, ei);
            createRes(res, smallAns, arr[i]);
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> findQuadraple(int[] arr, int n, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int si = 0;
        int ei = n - 1;
        for (int i = si; i <= ei; i++) {
            if (i != si && arr[i] == arr[i - 1])
                continue;
            ArrayList<ArrayList<Integer>> smallAns = threeSum(arr, target - arr[i], i + 1, ei);
            createRes(res, smallAns, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        System.out.println("");
        int target = s.nextInt();
        System.out.println(findQuadraple(arr, n, target));
    }
}
