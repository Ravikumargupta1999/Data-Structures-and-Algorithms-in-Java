public class Richest_Customer_Wealth {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int temp = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            if (temp > ans)
                ans = temp;
        }
        return ans;
    }

    public int maximumWealth1(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] temp : accounts)
        {
            int sum = 0;
            for(int val : temp)
                sum += val;
            if(sum > ans)
                ans = sum;
        }
        return ans;
    }
}