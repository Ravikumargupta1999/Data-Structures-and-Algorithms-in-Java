package Sumit_Malik_Level_2;

public class Practice_7_Power_Of_2 {
    // https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
    public static boolean isPowerOfTwo(long n){
        if( n == 0 ){
            return false;
        }else if( n == 1){
            return true ;
        }
        return (n & ( n-1) ) == 0 ? true : false;
    }
}
