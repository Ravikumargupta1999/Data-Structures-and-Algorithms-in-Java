public class Practice_12_Check_If_String_Is_Rotated_By_Two_Places {
    // https://practice.geeksforgeeks.org/problems/check-if-string-is-rotated-by-two-places-1587115620/1?page=6&company[]=Amazon&sortBy=submissions

    //                0  1  2  3  4   5
    //            a = a  m  a  z  o   n
//                b = a  z  o  n  a   m
//                a = a  m  a  z  o   n
    public static boolean isRotated(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        if (str1.length() == 1)
            return true;
        return (checkClockWise(str1, str2) || checkClockWise(str2, str1));
    }

    public static boolean checkClockWise(String str1, String str2) {
        for (int i = 0; i < str2.length() - 2; i++) {
            if (str1.charAt(i) != str2.charAt(i + 2))
                return false;
        }
        int n = str1.length();
        return str1.charAt(n - 2) == str2.charAt(0) && str1.charAt(n - 1) == str2.charAt(1);
    }


}
