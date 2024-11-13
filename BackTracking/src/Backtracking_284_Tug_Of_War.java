import java.util.*;

public class Backtracking_284_Tug_Of_War {
    // https://www.youtube.com/watch?v=Q1fLW_zQr3M
//    static int minDiff = Integer.MAX_VALUE;
//    static String ans = "";
//
//    public static void solve(int[] arr, int vIdx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soSet1, int soSet2)
//    {
//        if(vIdx == arr.length)
//        {
//            int delta = Math.abs(soSet1 - soSet2);
//            if(delta< minDiff)
//            {
//                minDiff = delta;
//                ans = set1 + " " + set2;
//            }
//            return;
//        }
//        if(set1.size()<(arr.length+1)/2)
//        {
//            set1.add(arr[vIdx]);
//            solve(arr, vIdx +1,set1,set2, soSet1 +arr[vIdx], soSet2);
//            set1.remove(set1.size()-1);
//        }
//        if(set2.size()<(arr.length+1)/2)
//        {
//            set2.add(arr[vIdx]);
//            solve(arr, vIdx +1,set1,set2, soSet1, soSet2 +arr[vIdx]);
//            set2.remove(set2.size()-1);
//        }
//
//    }
    public static void main(String[] args) {
        int[] arr = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int v : arr)
            arrayList.add(v);
        System.out.println(tugOfWar(arrayList, arrayList.size()));

    }

    public static int tugOfWar(ArrayList<Integer> num, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = num.get(i);
        }
        solve(arr, 0, new ArrayList<Integer>(), new ArrayList<Integer>(), 0, 0);
        return minDiff;
    }

    static int minDiff = 2147483647;

    public static void solve(int[] arr, int vIdx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soSet1, int soSet2) {
        if (vIdx == arr.length) {
            int delta = Math.abs(soSet1 - soSet2);
            minDiff = Math.min(delta,minDiff);
            System.out.println(set1+"  "+set2);
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
//    int arr[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};