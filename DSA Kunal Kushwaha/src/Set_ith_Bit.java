// https://practice.geeksforgeeks.org/problems/set-kth-bit3724/1
public class Set_ith_Bit {
    static int setithBit(int n, int i) {
        int mask = 1 << i;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(mask));
        return (n | mask);

    }

    public static void main(String[] args) {
        System.out.println(setithBit(10, 3));
    }
}
