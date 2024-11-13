package Day_16_String_II;

public class Count_And_Say {
    // https://leetcode.com/problems/count-and-say/submissions/
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        String temp = "11";
        for (int i = 3; i <= n; i++) {
            String res = "";
            char ch = temp.charAt(0);
            int count = 1;
            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) == ch)
                    count++;
                else {
                    res = res + count + ch;
                    ch = temp.charAt(j);
                    count = 1;
                }
            }
            res = res + count + ch;
            temp = res;
        }
        return temp;


    }
}
