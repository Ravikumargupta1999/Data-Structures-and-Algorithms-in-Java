

// Done
public class String_60_Check_Whether_One_String_is_A_Rotation_Of_Another {
    public static void main(String[] args) {

        String str1 = "ABACD";
        String str2 = "CDABA";
        boolean value = RotationString(str1, str2);
        System.out.println(value);

        System.out.println(check(str1, str2));

    }

    public static boolean check(String str1, String str2) {
        int val = (str1+str1).indexOf(str2);
        System.out.println(val);
        return (str1 + str1).contains(str2);
    }

    public static boolean RotationString(String s1, String s2) {
        String temp = s1.concat(s1);
        int n = temp.length();
        int m = s2.length();
//        "ABACD ABACD"

        for (int i = 0; i < n - m + 1; i++) {
            if (isMatch(temp, i, s2)) {
                return true;
            }

        }
        return false;
    }

    public static boolean isMatch(String text, int position, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(position + i) != pattern.charAt(i))
                return false;
        }
        return true;
    }
}
