// https://practice.geeksforgeeks.org/problems/copy-set-bits-in-range0623/1

public class Bit_Manipulation_478 {
    static int setSetBit(int x, int y, int l, int r){
        int mask = (1 << (r-l+1));
        mask--;
        mask = (mask << (l-1));
        mask = (mask & y);
        x = x | mask;
        return x;
    }

    public static void main(String[] args) {
        System.out.println(setSetBit(44,3,1,5));
    }

}
