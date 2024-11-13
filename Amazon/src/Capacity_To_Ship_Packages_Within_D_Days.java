// https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1/?company[]=Amazon&company[]=Amazon&page=1&category[]=Binary%20Search&query=company[]Amazonpage1company[]Amazoncategory[]Binary%20Search

public class Capacity_To_Ship_Packages_Within_D_Days {
    static int leastWeightCapacity(int[] arr, int n, int days) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<n;i++)
        {
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while ( low <= high)
        {
            int mid = low + (high-low)/2;
            if(isPossible(arr,mid,days))
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] wt,int mid,int days)
    {
        int d = 1;
        int sum = 0;
        for(int i=0;i<wt.length;i++)
        {
            sum += wt[i];
            if(sum > mid)
            {
                d++;
                sum = wt[i];
            }
        }
        return  d <= days;
    }

}
