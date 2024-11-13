import org.omg.Messaging.SYNC_WITH_TRANSPORT;

// https://practice.geeksforgeeks.org/problems/binary-representation5003/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=-2&page=1&query=category[]Bit%20Magicdifficulty[]-2page1category[]Bit%20Magic#

public class Binary_Representation {
    static int setBits(int n) {
        int counter = 0;
        while (n != 0) {
            int rightMostSetBit = (n & -n);
            n -= rightMostSetBit;
            counter++;
        }
        return counter;
    }
    static String getBinaryRep(int n) {

        String str = "";
        while (n >= 1) {
            if (n % 2 == 0) {
                str = 0 + str;
            } else {
                str = 1 + str;
            }
            n = n / 2;
        }
        int l = str.length();
        for (int i = str.length(); i < 30; i++) {
            str = 0 + str;
        }
        System.out.println(str.length());
        return str;
    }

    public static void main(String[] args) {
        System.out.println(getBinaryRep(5));
    }
}
