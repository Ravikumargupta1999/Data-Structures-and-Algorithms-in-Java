import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/check-if-the-number-is-fibonacci4654/1/?company[]=Adobe&company[]=Adobe&page=1&query=company[]Adobepage1company[]Adobe

public class Check_Fibonacci {
    static String checkFibonacci(int n){
        HashSet<Integer> set = new HashSet<>();
        int f[] = new int[20]; // 1 extra to handle case, n = 0
        int i;
        f[0] = 0;
        set.add(0);
        f[1] = 1;
        set.add(1);

        for (i = 2; i <= f.length-2; i++)
        {
            f[i] = f[i-1] + f[i-2];
            set.add(f[i]);
        }
        if(set.contains(n))
            return "YES";
        else
            return "NO";
    }
    public static void main(String[] args) {

    }
}
