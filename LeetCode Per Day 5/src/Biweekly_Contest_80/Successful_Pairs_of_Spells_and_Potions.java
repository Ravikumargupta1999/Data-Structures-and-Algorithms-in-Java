package Biweekly_Contest_80;

import java.util.ArrayList;
import java.util.Arrays;

public class Successful_Pairs_of_Spells_and_Potions {
    public static void main(String[] args) {
       int[] spells = {3,1,2};
       int[] potions = {8,5,8};
       long success = 16;
       System.out.println(Arrays.toString(successfulPairs(spells,potions,success)));
    }
    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            res[i] = binarySearch(potions, spells[i], success);
        }
        return res;
    }

    public static int binarySearch(int[] position, int num, long success) {
        if ((long) position[position.length - 1] * (long) num < success)
            return 0;
        else if ((long) position[0] * (long) num >= success)
            return position.length;
        int left = 0;
        int right = position.length - 1;
        int res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            long val = (long) (position[mid]) * (long) (num);
            if(val < success){
                res = (position.length-mid-1);
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return res;
    }

}
