import java.util.*;

public class Backtracking_281_All_Possible_Palindromic_Partitions_Of_A_String {
    public static void main(String[] args) {
        System.out.println(allPalindromicPerms("naman"));
    }

    // https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/#
    //
    public static ArrayList<ArrayList<String>> allPalindromicPerms(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        solve(s, "", res);
        return res;
    }

    public static void solve(String str, String asf, ArrayList<ArrayList<String>> ans) {
        if (str.length() == 0) {
            String[] strings = asf.split(" ");
            ArrayList<String> arrayList = new ArrayList<>();
            for (String st : strings)
                arrayList.add(st);
            ans.add(arrayList);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i + 1);
            String right = str.substring(i + 1);
            if (isPalindrome(left)) {
                solve(right, asf + left + " ", ans);
            }
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1)
            return true;
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
