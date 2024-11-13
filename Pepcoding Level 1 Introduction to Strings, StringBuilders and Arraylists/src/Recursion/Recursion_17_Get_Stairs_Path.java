package Recursion;

import java.util.ArrayList;

public class Recursion_17_Get_Stairs_Path {
    public static void main(String[] args) {
        System.out.println(getStairsPath(4));
    }

    public static ArrayList<String> getStairsPath(int n) {
        if (n == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }
        if (n < 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            return arrayList;
        }
        ArrayList<String> al1 = getStairsPath(n - 1);
        ArrayList<String> al2 = getStairsPath(n - 2);
        ArrayList<String> al3 = getStairsPath(n - 3);
        ArrayList<String> al = new ArrayList<>();
        for (String st : al1) {
            al.add(1 + st);
        }
        for (String st : al2) {
            al.add(2 + st);
        }
        for (String st : al3) {
            al.add(3 + st);
        }
        return al;

    }

}
