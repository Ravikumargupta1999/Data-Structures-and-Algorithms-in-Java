import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// Done
public class String_61_A_Valid_Shuffle_Of_Two_Strings_Or_Not {
    // https://www.youtube.com/watch?v=qN_vwYtvFUM
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        String s2 = s.nextLine();
        String resultant = s.nextLine();
        boolean b = isShuffle(resultant, s1, s2);
        System.out.println(b);
    }

    public static boolean isShuffle(String resultant, String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l = resultant.length();
        if (l1 + l2 != l)
            return false;
        else {
            int i = 0;
            int j = 0;
            int k = 0;
            while (k < l) {
                if (i < l1 && s1.charAt(i) == resultant.charAt(k))
                    i++;
                else if (j < l2 && s2.charAt(j) == resultant.charAt(k))
                    j++;
                else
                    break;
                k++;
            }
            if (i < l1 || j < l2)
                return false;
            else
                return true;
        }
    }

    // https://leetcode.com/problems/shuffle-string/submissions/
    public static String restoreString(String s, int[] indices) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(new int[]{indices[i],s.charAt(i)-'a'});
        }

        Collections.sort(list, (a, b) -> {
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder("");
        for (int[] temp : list){
            char ch = (char) ('a' + temp[1]);
            sb.append(ch);
        }
        return sb.toString();
    }
}
