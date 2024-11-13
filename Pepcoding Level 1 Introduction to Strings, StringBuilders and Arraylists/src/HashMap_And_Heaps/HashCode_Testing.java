package HashMap_And_Heaps;

import java.nio.charset.StandardCharsets;

public class HashCode_Testing {
    public static void main(String[] args) {
//        int[] a = new int[3];
//        System.out.println(a.hashCode());
//        int[] temp = a;
//        System.out.println(a.hashCode());
//        System.out.println(temp.hashCode());
//
//        System.out.println("\n\n");
//        a = new int[4];
//        System.out.println(a.hashCode());
//        System.out.println("\n\n");
//
//        String str1 = "ravi";
//        System.out.println(str1.hashCode());
//        str1 = "rishika";
//        System.out.println(str1.hashCode());
//        String s = "ravi";  // try with Ravi
//        System.out.println(s.hashCode());
//        s = str1;
//        System.out.println(s.hashCode());


        Integer a = new Integer(9);
        Integer b = new Integer(9);
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(a == b);
        // if same integer's object is compared then their hashcode will be same whereas reference will be not


        StringBuilder sb1 = new StringBuilder("Ravi");
        StringBuilder sb2 = new StringBuilder("Ravi");
        System.out.println(sb1.hashCode() ==sb2.hashCode());

    }
}
