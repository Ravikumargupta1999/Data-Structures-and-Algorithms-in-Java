public class Max_Chunks_To_Make_Sorted_II {
    //https://leetcode.com/problems/max-chunks-to-make-sorted-ii/submissions/
    public int maxChunksToSorted(int[] arr) {
        int[] lmax = new int[arr.length+1];
        int[] rmin = new int[arr.length+1];
        lmax[0] = arr[0];
        for(int i=1;i<arr.length;i++)
        {
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        }
        rmin[arr.length] = Integer.MAX_VALUE;
        for(int i = rmin.length-2;i>=0;i--)
        {
            rmin[i] = Math.min(arr[i],rmin[i+1]);
        }
        int count = 0;
        for(int i=0;i<lmax.length-1;i++)
        {
            if(lmax[i] <= rmin[i+1])
                count++;
        }
        return count;
    }
}
