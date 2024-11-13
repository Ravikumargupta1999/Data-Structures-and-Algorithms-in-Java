import java.util.*;

// https://practice.geeksforgeeks.org/problems/pascal-triangle0652/1

public class Pascal_Triangle {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        long[][] arr = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arr[i][j] = 1;
                } else if (i == j) {
                    arr[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               System.out.print(arr[i][j]+"  ");
            }
            System.out.println("\n");
        }
        long val = 1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < i; j++)
                arr[i][j] = (arr[i - 1][j] % val + arr[i - 1][j - 1] % val) % val;
        }
        ArrayList<Long> al = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            al.add(arr[n-1][i]);
        }
        return al;
    }

    public static void main(String[] args) {
        Pascal_Triangle a = new Pascal_Triangle();
        System.out.println(a.nthRowOfPascalTriangle(100));
    }
}
