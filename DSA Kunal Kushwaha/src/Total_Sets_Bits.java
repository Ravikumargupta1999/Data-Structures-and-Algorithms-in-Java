import java.util.Arrays;

public class Total_Sets_Bits {
    // https://practice.geeksforgeeks.org/problems/set-bits0143/1
    public static int countBits1(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if( (n & 1) == 1)
                count++;
            n = n >> 1;
        }
        return count;
    }
    //https://leetcode.com/problems/counting-bits/
    public static int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        for(int i=1;i<=n;i++)
            arr[i] = countBits1(i);
        return arr;

    }
    private static int setBits(int n) {
        int count = 0;

//        while (n > 0) {
//            count++;
//            n -= (n & -n);
//        }

        while (n > 0) {
            count++;
            n = n & (n-1);
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println();
        System.out.println(Arrays.toString(countBits(5)));
    }
}
