// https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1/?company[]=Adobe&company[]=Adobe&page=1&query=company[]Adobepage1company[]Adobe
// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/

public class Rotations_String {

    public static boolean areRotations(String str1, String str2) {
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);
    }


    public static void main(String[] args) {
        System.out.println(areRotations("", ""));
    }
}
