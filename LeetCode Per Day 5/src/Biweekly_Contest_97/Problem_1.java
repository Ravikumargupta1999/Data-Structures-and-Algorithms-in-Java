package Biweekly_Contest_97;

import java.util.ArrayList;

public class Problem_1 {
    public static void main(String[] args) {

    }

    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            ArrayList<Integer> temp = new ArrayList<>();
            while (num != 0) {
                temp.add(num % 10);
                num = num / 10;
            }
            for (int i = temp.size() - 1; i >= 0; i--)
                list.add(temp.get(i));
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
