package Recursion;

import java.util.ArrayList;

public class Recursion_15_Get_Subsequence {
    public static ArrayList<String> getSubsequence(String str) {
        if (str.length() == 1) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            arrayList.add(str.charAt(0) + "");
            return arrayList;
        }
        String sub = str.substring(1);
        ArrayList<String> res = getSubsequence(sub);
        ArrayList<String> ans = new ArrayList<>();
        for (String st : res) {
            ans.add("" + st);
            ans.add(str.charAt(0) + st);

        }
        return ans;
    }
}
