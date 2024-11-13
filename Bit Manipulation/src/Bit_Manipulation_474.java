// https://practice.geeksforgeeks.org/problems/bit-difference-1587115620/1
// easy
public class Bit_Manipulation_474 {
    public static int countBitsFlip1(int a, int b){

        int val = a ^ b;
        return setBits(val);
    }
    static int setBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
    public static int countBitsFlip(int a, int b) {
        String str1 = Integer.toBinaryString(a);
        String str2 = Integer.toBinaryString(b);
        str1 = fun(str1);
        str2 = fun(str2);
       // System.out.println(str1);
      //  System.out.println(str2);
        int count = 0;
        for (int i = 0; i < str1.length(); i++)
            if (str1.charAt(i) != str2.charAt(i))
                count++;
        return count;

    }

    static String fun(String str) {
        String s = str;
        while (s.length() != 32) {
            s = "0" + s;
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
    }
}
