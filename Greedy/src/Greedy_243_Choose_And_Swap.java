import java.util.Arrays;

public class Greedy_243_Choose_And_Swap {
    static String chooseAndSwap(String s) {
        // https://www.youtube.com/watch?v=NhnsINajZRA&t=346s
        // https://practice.geeksforgeeks.org/problems/choose-and-swap0531/1
        int n = s.length();
        char[] str = s.toCharArray();
        int MAX = 26;
        int i, j = 0;
        int[] chk = new int[MAX];
        Arrays.fill(chk, -1);
        System.out.println(Arrays.toString(chk));
        for (i = 0; i < n; i++) {
            if (chk[str[i] - 'a'] == -1)
                chk[str[i] - 'a'] = i;
        }

        for (i = 0; i < n; i++) {

            boolean flag = false;
            for (j = 0; j < str[i] - 'a'; j++) {
                if (chk[j] > chk[str[i] - 'a']) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }

        if (i < n) {
            char ch1 = str[i];
            char ch2 = (char) (j + 'a');

            for (i = 0; i < n; i++) {
                if (str[i] == ch1)
                    str[i] = ch2;

                else if (str[i] == ch2)
                    str[i] = ch1;
            }
        }

        return String.valueOf(str);
    }

    public static void main(String[] args) {
        System.out.println(chooseAndSwap("ccad"));
    }
}
