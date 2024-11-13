//https://leetcode.com/problems/power-of-three/submissions/
public class Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if (n == 2147483647)
            return false;
        return checkPowerofThree(n, 1, 1);
    }

    public static boolean checkPowerofThree(int n, int ind, int sum) {
        if (n == sum)
            return true;
        if (n < sum)
            return false;
        return checkPowerofThree(n, ind + 1, (int) Math.pow(3, ind));
    }

    public static void main(String[] args) {
        int i=0;
        while (i<=31)
        {
            System.out.println((int) Math.pow(3,i++));
        }
        Power_of_Three a = new Power_of_Three();
        System.out.println(a.isPowerOfThree(2147483647));
    }
}
