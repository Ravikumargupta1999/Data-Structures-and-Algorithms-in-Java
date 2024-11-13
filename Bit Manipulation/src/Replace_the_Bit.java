// https://practice.geeksforgeeks.org/problems/replace-the-bit3212/1

public class Replace_the_Bit {
    static int replaceBit(int n, int k) {
        int val = n;
        String str = "";
        while (n >= 1) {
            if (n % 2 == 0) {
                str = 0 + str;
            } else {
                str = 1 + str;
            }
            n = n / 2;
        }
        if(k > str.length() || k == 0)
            return val;

        System.out.println(str);
        int l = str.length();
        System.out.println(str.substring(0,l-k));
        System.out.println(str.substring(l-k+1,l));


        str = str.substring(0,str.length()-k) + "1" + str.substring(l-k+1 , str.length());
        System.out.println(str);


        return 1;
    }

    public static void main(String[] args) {
      System.out.println(replaceBit(13,2));
    }
}
