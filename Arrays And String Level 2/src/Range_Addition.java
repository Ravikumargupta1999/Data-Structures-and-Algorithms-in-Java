import java.util.List;
import java.util.Scanner;

public class Range_Addition {
    public static int getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            ans[start] += inc;
            if (end + 1 < length) {
                ans[end + 1] += -inc;
            }
        }
        int sum = 0;
        for (int i = 1; i < length; i++) {
            sum += ans[i];
            ans[i] += sum;
        }

        return sum;
    }
    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] ans = new long[n] ;
        for(int i=0;i<queries.size();i++)
        {
            int start = queries.get(i).get(0);
            int end = queries.get(i).get(1);
            int inc = queries.get(i).get(2);

            ans[start] += inc;
            if (end + 1 < n) {
                ans[end + 1] += -inc;
            }
        }
        long sum = 0;
        for (int i = 1; i < n; i++) {
            sum += ans[i];
            ans[i] += sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] queries = new int[m][3];
        for(int i=0;i<n;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            queries[i][0] = a;
            queries[i][1] = b;
            queries[i][2] = c;

        }
        System.out.println(getModifiedArray(n,queries));
    }
}
