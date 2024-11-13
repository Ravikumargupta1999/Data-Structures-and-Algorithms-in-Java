import java.util.ArrayList;
import java.util.Arrays;

public class Video_43_Quadruple_Sum {

    public static void create(ArrayList<ArrayList<Integer>> res, ArrayList<ArrayList<Integer>> smallAns, int val) {
        for (ArrayList<Integer> al : smallAns) {
            al.add(0, val);
            res.add(al);
        }
    }

    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int target, int si, int ei) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int temp1 = si;
        int temp2 = ei;
        while (si < ei) {
            int sum = arr[si] + arr[ei];
            if (sum > target) {
                ei--;
            } else if (sum < target) {
                si++;
            } else {

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
            create(res, smallAns, arr[i]);
        }
        return res;
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int si = 0;
        int ei = arr.length - 1;
        for (int i = si; i <= ei; i++) {
            if (i != si && arr[i] == arr[i - 1])
                continue;
            ArrayList<ArrayList<Integer>> smallAns = threeSum(arr, target - arr[i], i + 1, ei);
            create(res, smallAns, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 5, 7, 8};
        System.out.println(fourSum(arr, 14));
    }
}
