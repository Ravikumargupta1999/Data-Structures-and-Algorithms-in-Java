import javax.sql.rowset.spi.SyncFactoryException;
import java.util.Arrays;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/maximum-index-1587115620/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Arrayscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Arrays#
// https://practice.geeksforgeeks.org/problems/maximum-index3307/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Arrayscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Arrays

public class Maximum_Index {

    // Inefficient
    static int maxIndexDiff(int arr[], int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int temp = 0;
                if (arr[i] - arr[j] >= 0) {
                    temp = i - j;
                    if (temp > max) {
//                        System.out.println(j + "  " + i);
                        max = temp;
                    }
                }
            }
        }
        return max;

    }

    static int maxIndexDiff1(int arr[], int n) {
        int leftmin[] = new int[n];
        leftmin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftmin[i] = Math.min(arr[i], leftmin[i - 1]);
        }
        int ans = 0;
//        System.out.println(Arrays.toString(leftmin));
        int maxDist = Integer.MIN_VALUE;
        int i = n - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
//            System.out.println(i+ "  "+j);
            if (arr[j] >= leftmin[i]) {
                maxDist = Math.max(maxDist, j - i);
                i--;
            } else
                j--;
        }

        return maxDist;

    }

    public static void main(String[] args) {
        int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        System.out.println(maxIndexDiff1(arr, arr.length));
    }
}
