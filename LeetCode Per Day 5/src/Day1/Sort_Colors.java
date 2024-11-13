package Day1;

public class Sort_Colors {
    // https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] nums) {
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums ){
            if(num == 0)
                c0++;
            else if(num == 1)
                c1++;
            else
                c2++;
        }
        int t = 0;
        while (c0--> 0)
            nums[t++] = 0;
        while (c1-- > 0)
            nums[t++] = 1;
        while (c2-- > 0)
            nums[t++] = 2;
    }
}
