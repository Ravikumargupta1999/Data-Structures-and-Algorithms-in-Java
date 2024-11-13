package Day_25_Dynamic_Programming;

public class Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int cProd = 1;
        for (int i = 0; i < nums.length; i++) {
            cProd *= nums[i];
            ans = Math.max(ans, cProd);
            if (cProd == 0)
                cProd = 1;
        }
        cProd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cProd *= nums[i];
            ans = Math.max(ans, cProd);
            if (cProd == 0)
                cProd = 1;
        }
        return ans;
    }
}
