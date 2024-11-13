public class The_Painters_Partition_Problem_II {
    // https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/0/?category[]=Binary%20Search&page=1&query=category[]Binary%20Searchpage1#
    // same as allocate minimum no pages
    static boolean isPossible(int[] arr, int k, long mid){
        int painterCount = 1;
        int lengthCount = 0;

        for(int i : arr){
            if(lengthCount + i <= mid){
                lengthCount += i;
            }else{
                painterCount++;
                if(painterCount > k || i > mid){
                    return false;
                }
                lengthCount = i;
            }
        }
        return true;
    }
    static long minTime(int[] arr,int n,int k){
        //code here
        long start = 0;
        long sum = 0;
        for(int i : arr){
            sum += i;
        }
        long end = sum;
        long ans = -1;
        long mid = start + (end - start)/2;

        while(start <= end){
            if(isPossible(arr,k,mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            mid = start + (end - start)/2;
        }
        return ans;
    }
}
