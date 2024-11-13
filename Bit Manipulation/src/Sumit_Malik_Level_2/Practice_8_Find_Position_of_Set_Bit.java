package Sumit_Malik_Level_2;

public class Practice_8_Find_Position_of_Set_Bit {
    // https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
    //  1
    //  1 0
    //   1 0 0
    //   1 0 0 0
    //   1 0 0 0 0
    static int findPosition(int n) {
        if( n == 0 )
            return -1;

        if ((n & (n - 1)) != 0)
            return -1;
        int rightMostSetBit = n & -n;

        for (int i = 0; i < 32; i++) {

            if ((rightMostSetBit & (1 << i)) > 0)
                return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPosition(8));
    }
}
