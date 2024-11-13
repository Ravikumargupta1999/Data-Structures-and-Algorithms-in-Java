public class Maximum_Repeating_Number {
    int maxRepeating(int[] arr, int n, int k) {
        // code here
        int[] counts = new int[k];
        for (int num : arr)
            counts[num]++;
        int max = 0;
        int count = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if(counts[i] > count)
            {
                count = counts[i];
                max = i;
            }
        }
        return max;
    }

}
