//
public class Bit_Manipulation_474_Sumit_Malik_Solution {
    public static int countBitsFlip(int a, int b){
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
}
