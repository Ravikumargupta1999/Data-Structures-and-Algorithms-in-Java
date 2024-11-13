import java.util.Arrays;
import java.util.Scanner;

public class ChocklateDistributionProblem {
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        while (t-- >0) {
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = s.nextInt();
            int m = s.nextInt();
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 0; i + m - 1 < n; i++) {
                int d = arr[i + m - 1] - arr[i];
                if (d < min)
                    min = d;
            }
            System.out.println(min);

        }
        return;
    }
}
