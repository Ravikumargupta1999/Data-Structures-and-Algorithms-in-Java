package Day1;

import java.util.ArrayList;
import java.util.List;

public class Compare_The_Triplets {
    // https://www.hackerrank.com/challenges/compare-the-triplets/problem
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        get(a.get(0), b.get(0), list);
        get(a.get(1), b.get(1), list);
        get(a.get(2), b.get(2), list);
        return list;

    }

    public static void get(int a, int b, List<Integer> list) {
        if (a == b) {
            return;
        } else if (a > b) {
            list.set(0,list.get(0)+1);
        } else {
            list.set(1,list.get(1)+1);
        }
    }
}
