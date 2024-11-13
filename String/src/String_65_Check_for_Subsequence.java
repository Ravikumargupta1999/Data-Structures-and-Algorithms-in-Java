public class String_65_Check_for_Subsequence {
//    https://practice.geeksforgeeks.org/problems/check-for-subsequence4930/1
    boolean isSubSequence(String A, String B) {
        int j = 0;
        for (int i = 0; i < A.length(); i++) {
            int temp = match(A.charAt(i), j, B);
            if (temp == -1)
                return false;
            j = temp;
        }
        return true;
    }

    int match(char ch, int pos, String B) {
        for (int i = pos; i < B.length(); i++)
            if (B.charAt(i) == ch)
                return i + 1;
        return -1;
    }

    public static void main(String[] args) {
        String A = "AXY";
        String B = "YADXCP";
        System.out.println(new String_65_Check_for_Subsequence().isSubSequence(A,B));
    }
}
