import java.util.*;

// https://practice.geeksforgeeks.org/problems/largest-rectangular-sub-matrix-whose-sum-is-0/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class D_Dynamic_Programming_464_Largest_rectangular_sub_matrix_whose_sum_is_0_GFG {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            int[] temp = new int[a[0].length];
            for (int j = i; j < a.length; j++) {

                for (int col = 0; col < a[0].length; col++) {
                    temp[col] += a[j][col];
                }


                int[] res = largestSubArrayWithZeroSum(temp, temp.length);
                if (res[0] != -1) {
                    arrayList.add(new int[]{i, j, res[0], res[1]});
                }
            }
        }

        if (arrayList.size() == 0)
            return new ArrayList<>();

//
//        for (int[] t : arrayList) {
//            System.out.println(t[0]+"  "+t[1]+"   "+t[2]+"    "+t[3]);
//
//        }
//        System.out.println("\n");

        Collections.sort(arrayList, (arr1, arr2) -> {
            if (((arr1[1] - arr1[0] + 1) * (arr1[3] - arr1[2] + 1)) != ((arr2[3] - arr2[2] + 1) * (arr2[1] - arr2[0] + 1)))
                return ((arr2[3] - arr2[2] + 1) * (arr2[1] - arr2[0] + 1)) - ((arr1[1] - arr1[0] + 1) * (arr1[3] - arr1[2] + 1));
            else if (arr1[3] != arr2[3])
                return arr1[3] - arr2[3];
            else if (arr1[0] != arr2[0])
                return arr1[0] - arr2[0];
            return arr2[1] - arr1[1];
        });
        if (arrayList.size() == 0) {
            return new ArrayList<>();
        }

        int[] res = arrayList.get(0);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = res[0]; i <= res[1]; i++) {
            ArrayList<Integer> ar = new ArrayList<>();
            for (int j = res[2]; j <= res[3]; j++) {
                ar.add(a[i][j]);
            }
            result.add(ar);
        }
        return result;
    }

    public static int[] largestSubArrayWithZeroSum(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int i = -1;
        int sum = 0;
        int maxLength = 0;

        map.put(sum, i);


        int start = -1;
        int end = -1;


        while (i < arr.length - 1) {
            i++;
            sum += arr[i];
            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                if (len > maxLength) {
                    start = map.get(sum) + 1;
                    end = i;
                    maxLength = len;
                }
            } else {
                map.put(sum, i);
            }
        }
        return new int[]{start, end};
    }

}
//27 21 -22 -48
//        -38 -10 -40 40
//        42 6 -15 -35