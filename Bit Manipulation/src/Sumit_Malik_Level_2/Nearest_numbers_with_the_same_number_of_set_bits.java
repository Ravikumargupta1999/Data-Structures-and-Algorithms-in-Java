package Sumit_Malik_Level_2;

import java.util.ArrayList;

public class Nearest_numbers_with_the_same_number_of_set_bits {
    // https://www.codingninjas.com/codestudio/problems/nearest-numbers-with-the-same-number-of-set-bits_1172161?leftPanelTab=1

    public static ArrayList<Integer> nearestNumbers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = countSetBits(n);
        int val = n;
        while (true) {
            val++;
            int countSet = countSetBits(val);
            if (countSet == temp) {
                list.add(val);
                break;
            }
        }
        val = n;
        while (val >= 0){
            val--;
            int countSet = countSetBits(val);
            if (countSet == temp) {
                list.add(val);
                break;
            }
        }
        if(list.size() == 1){
            list.add(Integer.MAX_VALUE);
        }
        return list;
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            int rightMostSetBit = n & -n;
            n = n - rightMostSetBit;
            count++;
        }
        return count;
    }
}
