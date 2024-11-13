public class Remove_Digit_From_Number_To_Maximize_Result {
    // https://leetcode.com/contest/weekly-contest-291/problems/remove-digit-from-number-to-maximize-result/
    public String removeDigit(String number, char digit) {
        String max = "0";

        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != digit)
                continue;

            String temp = number.substring(0, i) + number.substring(i + 1);
            if(String.valueOf(temp).compareTo(max) > 0)
                max = temp;
        }
        return max;
    }


}
