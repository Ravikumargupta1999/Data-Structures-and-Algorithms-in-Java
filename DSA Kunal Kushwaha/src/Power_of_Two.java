//https://leetcode.com/problems/power-of-two/submissions/
public class Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        if( n == 2147483647)
            return false;
        return checkPowerofTwo(n,1,1);
    }
    public static boolean checkPowerofTwo(int n,int ind,int sum)
    {
        if( n == sum)
            return true;
        if(n < sum)
            return false;
        return checkPowerofTwo(n,ind+1,(int) Math.pow(2,ind));
    }

    public static void main(String[] args) {
        int i=0;
        while (i<=31)
        {
            System.out.println((int) Math.pow(2,i++));
        }
        Power_of_Two a = new Power_of_Two();
        System.out.println(a.isPowerOfTwo(2147483646));
    }
}
