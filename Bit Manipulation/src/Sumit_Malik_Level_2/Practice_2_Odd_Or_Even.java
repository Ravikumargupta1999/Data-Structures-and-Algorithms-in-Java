package Sumit_Malik_Level_2;

public class Practice_2_Odd_Or_Even {
    //     // https://practice.geeksforgeeks.org/problems/even-and-odd/1
    static String oddEven(int N) {
        return ((N & 1) == 0) ? "even" : "odd";
    }
}
