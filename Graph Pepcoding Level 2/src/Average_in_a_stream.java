public class Average_in_a_stream {
    // https://practice.geeksforgeeks.org/problems/average4856/0/?difficulty[]=-2&page=4&query=difficulty[]-2page4
    float[] streamAvg(int[] arr, int n) {
        int sum = 0;
        float[] ans = new float[n];
        for(int i=0;i<n;i++)
        {
            sum += arr[i];
            float a =  ((float)sum)/(i+1);
            ans[i] = a;
        }
        return ans;
    }
}
