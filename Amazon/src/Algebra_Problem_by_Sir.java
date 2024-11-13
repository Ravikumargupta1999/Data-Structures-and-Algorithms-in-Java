/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef1 {
    public static void main(String[] args) throws java.lang.Exception {

        Scanner s = new Scanner(System.in);
        Double t = s.nextDouble();
        while (t-- > 0) {
            Double x = s.nextDouble();
            Double y = s.nextDouble();

            Double temp = x * 10;
            Double j = temp;

            for (j = temp; j < (Double) Math.pow(10, 18); j++) {
                System.out.println(j);
                
                if (j % y == 0 && check(j, x) == true) {
                    System.out.println(j);
                    break;
                }
            }
            if (j >= (Double) Math.pow(10, 18))
                System.out.println(-1);
        }

    }

    public static boolean check(Double i, Double x) {
        String str1 = Double.toString(i);
        String str2 = Double.toString(x);
        String temp = "";
        for (int l = 0; l < str2.length(); l++) {
            temp = temp + "" + str1.charAt(l);
        }
        if (temp.equals(str2))
            return true;
        else
            return false;
    }
}
