//https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1#
public class Arithmetic_Number {
    static int inSequence(int A, int B, int C){
        if( A < B) {
            int num = A;
            while (num <= B) {
                num = num + C;
                if (num == B)
                    return 1;
            }
        }
        else
        {
            int num = A;
            while (num > B) {
                num = num + C;
                if (num == B)
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(inSequence(-2,-9,-7));
    }
}
