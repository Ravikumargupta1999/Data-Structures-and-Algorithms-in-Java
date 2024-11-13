public class Equilibrium_index_of_an_array {
    public static int findEquilibrium(int arr[], int n)
    {
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
}
//https://practice.geeksforgeeks.org/problems/equilibrium-index-of-an-array/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=3&query=company[]Amazondifficulty[]0page3company[]Amazon
