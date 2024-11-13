import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/three-sum-closest/1/?company[]=Google&company[]=Google&difficulty[]=0&page=2&query=company[]Googledifficulty[]0page2company[]Google
// https://leetcode.com/problems/3sum-closest/
// https://www.youtube.com/watch?v=qBr2hq4daWE
public class Practice_7_Three_Sum_Closest {
    // Leetcode
    static int threeSumClosest(int[] arr, int target) {
        int result = arr[0] + arr[1] + arr[arr.length - 1];
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int a = i + 1;
            int b = arr.length - 1;
            while (a < b) {
                int csum = arr[i] + arr[a] + arr[b];
                if (csum > target) {
                    b -= 1;
                } else {
                    a += 1;
                }
                if (Math.abs(csum - target) < Math.abs(result - target))
                    result = csum;
            }
        }
        return result;
    }

    // Gfg
    static int threeSumClosest1(int[] arr, int target) {

        Arrays.sort(arr);
        int result = arr[0] + arr[1] + arr[arr.length - 1];
        for (int i = 0; i < arr.length - 2; i++) {
            int a = i + 1;
            int b = arr.length - 1;
            while (a < b) {
                int csum = arr[i] + arr[a] + arr[b];
                if (csum > target) {
                    b -= 1;
                } else {
                    a += 1;
                }
                if (Math.abs(csum - target) < Math.abs(result - target))
                    result = csum;
                if (Math.abs(csum - target) == Math.abs(result - target)) {
                    if (result < csum) {
                        result = csum;
                    }
                }
            }
        }
        return result;
    }
}
