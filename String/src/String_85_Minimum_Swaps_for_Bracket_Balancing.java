import java.util.ArrayList;

// https://www.youtube.com/watch?v=Ylz6mwghDrU&t=907s
// https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1
public class String_85_Minimum_Swaps_for_Bracket_Balancing {
    // Method 1
    public static int MinimumSwap1(String S) {
        char[] str = S.toCharArray();
        ArrayList<Integer> al = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '[') {
                al.add(i);
            }
        }
        int idx = 0;
        ans = 0;
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '[') {
                count++;
                idx++;
            } else {
                count--;
                if (count < 0) {
                    ans += al.get(idx) - i;
                    char temp = str[i];
                    str[i] = str[al.get(idx)];
                    str[al.get(idx)] = temp;
                    count = 1;  // phir se close ka count
                    idx++;
                    //    System.out.println(ans);
                }
            }
        }
        return ans;
    }

    // Method 2
    public static int MinimumSwap(String S) {
        int op = 0;

        int cl = 0;

        int swap = 0;

        for (int i = 0; i < S.length(); i++) {

            if (S.charAt(i) == '[')

                op++;

            else {

                if (op > 0)

                    op--;

                else

                    cl++;

//swapping will be adjacent

//therefore, if ']' encountered, then whatever extra closing brackets will be there, it will take that many swaps for that particular ']' to move '[' to ']'

                if (cl > op)

                    swap += cl - op;

            }

        }

        return swap;
    }



}

