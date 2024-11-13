public class Backtracking_292_Partition_array_to_K_Subsets {
    public boolean isKPartitionPossible(int nums[], int n, int k)
    {

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if( k > n || sum % k != 0)
            return false;
        // System.out.println("G");
        return canPartition(nums,new boolean[n],0,k,0,sum/k);
    }
    public boolean canPartition(int[] arr,boolean[] visited,int index,int k,int curSum,int subsetSum){
        if(k == 0)
            return true;
        if(curSum > subsetSum)
            return false;
        if(curSum == subsetSum)
            return canPartition(arr,visited,0,k-1,0,subsetSum);

        for(int i=index;i<arr.length;i++){
            if(visited[i] || curSum+arr[i] > subsetSum )
                continue;
            visited[i]= true;
            if(canPartition(arr,visited,i+1,k,curSum+arr[i],subsetSum))
                return true;
            visited[i]= false;
        }
        return false;
    }
}
//N = 5
//        a[] = {2,1,4,5,6}
//        K = 3
//7
//        4 3 2 3 5 2 1
//        5