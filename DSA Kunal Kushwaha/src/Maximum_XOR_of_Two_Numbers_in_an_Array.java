public class Maximum_XOR_of_Two_Numbers_in_an_Array {
   // Time Limit Exceed
    public int findMaximumXOR(int[] arr) {
        int ans = 0;
        for (int i=0;i<arr.length-1;i++)
        {
            int temp = arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                if((temp^arr[j]) > ans)
                    ans = (temp^arr[j]);
            }
        }
        return ans;

    }
}
