package InterviewQuestion;

public class Video_79_Multiply_Two_String {
    // https://leetcode.com/problems/multiply-strings/submissions/
    public String multiply(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");

        String s1 = new StringBuilder(num1).reverse().toString();
        String s2 = new StringBuilder(num2).reverse().toString();
        int pos = 0;
        int i = 0;
        while (i < s2.length()) {

            StringBuilder temp = new StringBuilder();
            int ravi = pos;
            while (ravi-- > 0)
                temp.append(0);
            pos++;
            int j = 0;
            int val2 = Character.getNumericValue(s2.charAt(i));
            int carry = 0;

            while (j < s1.length() || carry > 0) {
                int val1 = j < s1.length() ? Character.getNumericValue(s1.charAt(j)) : 0;
                int res = val1 * val2 + carry;
//                System.out.println(val1 + "   " + val2 + "  " + carry + "   " + res);
                temp.append(res % 10);
                carry = res / 10;
                j++;
            }
//            System.out.println(temp.toString());
            sb = addStrings(sb.toString(), temp.reverse().toString());
            i++;
        }
        for (i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0')
                return sb.substring(i).toString();
        }
        return "0";
    }

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

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "456";
        System.out.println(new Video_79_Multiply_Two_String().multiply(s1, s2));
    }
}
