import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/missing-intervals3058/1/?company[]=Google&company[]=Google&difficulty[]=1&page=3&query=company[]Googledifficulty[]1page3company[]Google

public class Practice_15_Missing_Intervals {
    static int[] printMissingIntervals(int[] arr, int n) {
        // your code should return an Array if you are Coding in JAVA!
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] == 0)
                    continue;
                else if (arr[i] == 1) {
                    arrayList.add(0);
                    arrayList.add(0);
                } else if (arr[i] >= 2) {
                    arrayList.add(0);
                    arrayList.add(arr[i] - 1);
                }
            } else {
                if (arr[i] - arr[i - 1] == 1) {
                    continue;
                } else if (arr[i] - arr[i - 1] == 2) {
                    arrayList.add(arr[i - 1] + 1);
                    arrayList.add(arr[i - 1] + 1);
                } else {
                    arrayList.add(arr[i - 1] + 1);
                    arrayList.add(arr[i] - 1);
                }
            }
        }
        if (arr[n - 1] == 99999) {
            int[] res = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++)
                res[i] = arrayList.get(i);
            return res;
        } else if (arr[n - 1] == 99998) {
            arrayList.add(99999);
            arrayList.add(99999);
            int[] res = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++)
                res[i] = arrayList.get(i);
            return res;
        } else {
            arrayList.add(arr[n - 1] + 1);
            arrayList.add(99999);
            int[] res = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++)
                res[i] = arrayList.get(i);
            return res;
        }
    }

}
