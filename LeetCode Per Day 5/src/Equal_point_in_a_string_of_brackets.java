public class Equal_point_in_a_string_of_brackets {
    public long countSub(String str) {
        int[] left = new int[str.length()];
        left[0] = 0;
        for (int i = 1; i < str.length(); i++) {
            left[i] = left[i - 1];
            if (str.charAt(i - 1) == '(')
                left[i]++;
        }
        int[] right = new int[str.length()];
        if (str.charAt(str.length() - 1) == ')')
            right[str.length() - 1]++;
        for (int i = str.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1];
            if (str.charAt(i) == ')')
                right[i]++;
        }
        int i = 0;
        for (i = 0; i < str.length(); i++) {
            if(left[i] == right[i])
                return i;
        }
        return i;
    }
}
