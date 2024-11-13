public class Turnoff_A_Bit {
// https://www.geeksforgeeks.org/how-to-turn-off-a-particular-bit-in-a-number/
    public static int turnoffBit(int n,int i)
    {
        if(i <= 0)
            return n;
        return (n & (~(1<<(i-1))));
    }
    public static void main(String[] args) {
        System.out.println(turnoffBit(15,1));
    }
}
