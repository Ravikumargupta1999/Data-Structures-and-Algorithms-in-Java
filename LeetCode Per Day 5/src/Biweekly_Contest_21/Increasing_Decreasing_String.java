package Biweekly_Contest_21;

public class Increasing_Decreasing_String {
    public String sortString(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray())
            arr[ch - 'a']++;
        s = "";
        while (true) {
            boolean f1 = false;

            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    arr[i]--;
                    s = s + (char) ('a' + i);
                    f1 = true;
                }
            }
            if (!f1)
                return s;
            boolean f2 = false;
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    arr[i]--;
                    s = s + (char) ('a' + i);
                    f2 = true;
                }
            }
            if (!f2)
                return s;
        }
    }
}
