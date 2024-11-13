package Biweekly_Contest_79;

public class Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value {
    public boolean digitCount(String num) {
        int[] arr = new int[10];
        for (char ch : num.toCharArray()) {
            arr[ch - '0']++;
        }
        for (int i = 0; i < num.length(); i++) {
            int times = num.charAt(i) -'0';
            if(times != arr[i])
                return false;
        }
        return true;
    }
}
