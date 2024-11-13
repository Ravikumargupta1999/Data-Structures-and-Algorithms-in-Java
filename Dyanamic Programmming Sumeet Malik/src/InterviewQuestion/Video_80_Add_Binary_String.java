package InterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Video_80_Add_Binary_String {
    // https://leetcode.com/problems/add-binary/submissions/
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int i = 0;
        int j = 0;
        int carry = 0;

        while (i < a.length() || j < b.length() || carry > 0) {
            int sum = i < a.length() ? Character.getNumericValue(a.charAt(i)) : 0;
            sum += (j < b.length() ? Character.getNumericValue(b.charAt(j)) : 0);
            sum += carry;
            res.append(sum % 2);
            carry = sum / 2;
            i++;
            j++;
        }
        return res.reverse().toString();
    }
    // https://leetcode.com/problems/plus-one/
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry = 1;
        for (int j = digits.length - 1; j >= 0; j--) {
            int sum = digits[j];
            sum += carry;
            list.add(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0)
            list.add(carry);
        Collections.reverse(list);
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
