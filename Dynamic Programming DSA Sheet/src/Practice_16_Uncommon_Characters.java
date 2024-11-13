import java.util.HashSet;

public class Practice_16_Uncommon_Characters {
    String UncommonChars(String A, String B)
    {
        int[] arr1 = new int[26];
        for (char ch : A.toCharArray())
            arr1[ch - 'a']++;
        int[] arr2 = new int[26];
        for (char ch : B.toCharArray())
            arr2[ch - 'a']++;

        String res = "";
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != 0 && arr2[i] != 0)
                continue;
            else if (arr1[i] != 0 || arr2[i] != 0)
                res += "" + (char) ('a' + i);
        }
        if(res.length() == 0)
            res += "-1";
        return res;
    }
}
