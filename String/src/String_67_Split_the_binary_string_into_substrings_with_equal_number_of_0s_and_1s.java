public class String_67_Split_the_binary_string_into_substrings_with_equal_number_of_0s_and_1s {
    // https://practice.geeksforgeeks.org/problems/split-the-binary-string-into-substrings-with-equal-number-of-0s-and-1s/1/#

    public static int maxSubStr(String str) {
        int count = 0;
        int total = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0')
                count++;
            else
                count--;
            total = count == 0 ? total + 1 : total;
        }
        return count == 0 ? total : -1;
    }
}
