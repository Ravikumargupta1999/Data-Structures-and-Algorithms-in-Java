package Day_1_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
    public static void main(String[] args) {
        System.out.println(generate(592));
    }
    // https://leetcode.com/problems/pascals-triangle/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if (numRows == 1)
            return res;

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(1);
        res.add(list1);

        if (numRows == 2)
            return res;

        for (int n = 2; n < numRows; n++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            for (int i = 1; i < res.get(n-1).size(); i++) {
                temp.add(res.get(n-1).get(i) + res.get(n-1).get(i - 1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    // https://www.codingninjas.com/codestudio/problems/1089580?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
    public static ArrayList<ArrayList<Long>> printPascal(int numRows) {
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        ArrayList<Long> list = new ArrayList<>();
        list.add( (long)1);
        res.add(list);
        if (numRows == 1)
            return res;

        ArrayList<Long> list1 = new ArrayList<>();
        list1.add((long)1);
        list1.add((long)1);
        res.add(list1);

        if (numRows == 2)
            return res;

        for (int n = 2; n < numRows; n++) {
            ArrayList<Long> temp = new ArrayList<>();
            temp.add((long)1);

            for (int i = 1; i < res.get(n-1).size(); i++) {
                temp.add(res.get(n-1).get(i) + res.get(n-1).get(i - 1));
            }
            temp.add((long)1);
            res.add(temp);
        }
        return res;
    }
}

