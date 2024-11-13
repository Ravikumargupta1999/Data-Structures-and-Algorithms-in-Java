
// https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1#
// https://www.youtube.com/watch?v=yroWfS5P2E4
public class Maximum_Sum_In_Configration {
    static int maxumumSum(int[] arr,int n)
    {
        int sum = 0;
        int s0 = 0;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            s0 += arr[i]*i;
        }
        int max = s0;
        int si = s0;

        for(int i=0;i<n-1;i++)
        {
            int sip1 = si + sum - n*arr[n-1-i];
//            System.out.println(sip1+"  "+max);
            if(sip1 > max)
                max = sip1;
            si = sip1;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr= {8,3,1,2};
        System.out.println(maxumumSum(arr,arr.length));

    }
}
