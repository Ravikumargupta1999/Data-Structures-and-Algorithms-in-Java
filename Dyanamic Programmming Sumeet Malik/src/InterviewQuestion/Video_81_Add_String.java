package InterviewQuestion;

public class Video_81_Add_String {
    // https://leetcode.com/problems/add-strings/submissions/
    public StringBuilder addStrings(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        s1 = new StringBuilder(s1).reverse().toString();
        s2 = new StringBuilder(s2).reverse().toString();
        int i = 0;
        int j = 0;
        int carry = 0;
        while (i < s1.length() || j < s2.length() || carry > 0) {
            int sum = 0;
            sum += (i < s1.length() ? Character.getNumericValue(s1.charAt(i)) : 0);
            sum += (j < s2.length() ? Character.getNumericValue(s2.charAt(j)) : 0);
            sum += carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i++;
            j++;
        }
        return sb.reverse();
    }
}
