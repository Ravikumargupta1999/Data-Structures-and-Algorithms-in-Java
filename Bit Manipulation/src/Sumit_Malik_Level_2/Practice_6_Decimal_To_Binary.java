package Sumit_Malik_Level_2;

public class Practice_6_Decimal_To_Binary {
    // https://practice.geeksforgeeks.org/problems/decimal-to-binary-1587115620/1?page=1&difficulty[]=-1&category[]=Bit%20Magic&sortBy=submissions
    void toBinary(int N) {
        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            if (N % 2 == 0) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            N = N / 2;
        }
        sb.reverse();
        System.out.print(sb);
    }
}
