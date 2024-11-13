import java.util.Scanner;

public class Sales {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                arr[i][j] = s.nextInt();
            }
        }
        int[] res = function(arr);
        for(int i=0;i<res.length;i++)
            System.out.print(res[i]+" ");
        System.out.println("");
    }
    public static int[] function(int[][] arr)
    {
        int[] res = new int[arr[0].length];
        int k = 0;
        for (int j = 0;j<arr[0].length;j++)
        {
            int min = arr[0][j];
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i][j] < min)
                    min = arr[i][j];
            }
            res[k] = min;
            k++;
        }
        return res;
    }
}
