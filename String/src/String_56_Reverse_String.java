//Done
public class String_56_Reverse_String {
  // https://leetcode.com/problems/reverse-string/
    public static char[] reverseString(char[] s) {
        int i = 0;
        int j = s.length-1;
        while (i<=j)
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
        return s;
    }
}
