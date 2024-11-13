// https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1/?company[]=Adobe&company[]=Adobe&page=2&query=company[]Adobepage2company[]Adobe
public class Equilibrium_Point {
    public static int equilibriumPoint(long arr[], int n) {
        long total_sum = 0;
        for(int i=0;i<n;i++)
        {
            total_sum += arr[i];
        }

        long left_sum = 0;
        for(int i=0;i<n;i++)
        {
            total_sum = total_sum - arr[i];
            if(left_sum == total_sum)
                return i+1;
             left_sum = left_sum + arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        long[] arr = {2};
        System.out.println(equilibriumPoint(arr,arr.length));

    }
}
