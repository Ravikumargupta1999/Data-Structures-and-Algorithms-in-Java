package Biweekly_Contest_98;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem_4 {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public int minMaxDifference(int num) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();


        while (num != 0) {
            list1.add(num % 10);
            list2.add(num % 10);
            set1.add(num % 10);
            set2.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(list1);
        Collections.reverse(list2);

        for (int i = 0; i < 10; i++) {
            if (set1.contains(i))
                changeMax(list1, i, 9, true);
        }
        for (int i = 0; i < 10; i++) {
            if (set2.contains(i))
                changeMax(list2, i, 0, false);
        }
        return max - min;
    }

    public void changeMax(ArrayList<Integer> list, int digit, int change, boolean flag) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == digit)
                temp.add(change);
            else
                temp.add(list.get(i));
        }
        if (flag)
            max = Math.max(max, getNum(temp));
        else
            min = Math.min(min, getNum(temp));


    }

    public int getNum(ArrayList<Integer> list) {
        int num = 0;

        for (int i = 0; i < list.size(); i++) {
            num = num * 10 + list.get(i);
        }
        return num;
    }
}
