package Biweekly_Contest_89;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Program_2 {

    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        String str = Integer.toBinaryString(n);
        int k = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1')
                list.add(1 << k);
            k++;

        }


        Collections.sort(list);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int temp = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                if (j >= list.size())
                    break;
                temp = (int) (((long)temp % mod * (long)list.get(j) % mod) % (long)mod);
                temp = temp % mod;
            }

            res[i] = temp;
        }
        return res;
    }
    public int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int num = 10001;
        while (num >= 1) {
            if(set.contains(num) && set.contains(-num))
                return num;
            num--;
        }
        return -1;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int num : nums)
            set.add(reve(num));
        return set.size();
    }
    int reve(int number){
        int reverse = 0;
        while(number != 0)
        {
            int remainder = number % 10;
            reverse = reverse * 10 + remainder;
            number = number/10;
        }
        return reverse;
    }
    public boolean sumOfNumberAndReverse(int num) {
        int ans = 0;

        while (ans <= num){
            if(ans + reve(ans) == num)
                return true;
            ans++;
        }
        return false;
    }
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long c = 0;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if(nums[i] == minK && nums[i] == maxK)
                    c++;
            }
        }
        return c;
    }


    public static void main(String[] args) {
        int n = 13;
        int[][] queries = {{1, 2}, {1, 1}};
        System.out.println(Arrays.toString(productQueries(n, queries)));
    }
}
