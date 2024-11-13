public class Row_with_minimum_number_of_1s {
    int minRow(int n, int m, int a[][]) {
        int ans = 0;
        int max_count = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++)
        {
            int count = 0;
            for (int j=0;j<n;j++) {
                if(a[i][j] == 1)
                    count++;
            }
            if(count < max_count) {
                ans = i+1;
                max_count = count;
            }
        }
        return ans;
        // code here
    }
}
