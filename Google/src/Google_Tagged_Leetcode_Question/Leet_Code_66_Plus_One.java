package Google_Tagged_Leetcode_Question;

import java.util.ArrayList;
import java.util.Collections;

public class Leet_Code_66_Plus_One {
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
        int[] res = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return res;
    }
}
