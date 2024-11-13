package Biweekly_Contest_92;

public class Minimum_Cuts_to_Divide_a_Circle {
    public int numberOfCuts(int n) {
        if(n == 1){
            return 0;
        }
        if(n % 2 == 0)
            return n/2;
        return n;
    }
}
