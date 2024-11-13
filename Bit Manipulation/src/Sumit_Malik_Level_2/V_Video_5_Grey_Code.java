package Sumit_Malik_Level_2;

import java.util.ArrayList;
import java.util.List;

// https://www.youtube.com/watch?v=KOD2BFauQbA&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=5
public class V_Video_5_Grey_Code {
    // https://practice.geeksforgeeks.org/problems/gray-code-1611215248/1/
    public static ArrayList<String> graycode(int n) {
        if (n == 1) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("0");
            arr.add("1");
            return arr;
        }
        ArrayList<String> rres = graycode(n - 1);
        ArrayList<String> mres = new ArrayList<>();
        for (int i = 0; i < rres.size(); i++) {
            String str = rres.get(i);
            mres.add("0" + str);
        }
        for (int i = rres.size() - 1; i >= 0; i--) {
            String str = rres.get(i);
            mres.add("1" + str);
        }
        return mres;
    }

    // https://leetcode.com/problems/gray-code/submissions/
    public static List<Integer> grayCode(int n) {
        ArrayList<String> result = graycode(n);
        List<Integer> al = new ArrayList<>();
        for (String str : result) {
            al.add(Integer.parseInt(str, 2));
        }
        return al;

    }
}
