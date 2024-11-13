package Recursion;

import java.util.ArrayList;

public class Recursion_21_Print_Permutations {
    public static void main(String[] args) {
        ArrayList<String> res = new ArrayList<>();
        printPermutation("abc", "", res);
        System.out.println(res);
    }

    public static void printPermutation(String str, String asf, ArrayList<String> res) {
        if (str.length() == 0) {
            res.add(asf);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.length()+"   "+(i+1)+"   "+str);
            printPermutation(str.substring(0, i) + str.substring(i + 1), asf + str.charAt(i), res);
        }
    }
}
