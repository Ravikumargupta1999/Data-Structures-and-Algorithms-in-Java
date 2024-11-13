public class Power_of_Four {
    public boolean isPowerOfFour(int n) {
        if (n == 2147483647)
            return false;
        return checkPowerofFour(n, 1, 1);
    }

    public static boolean checkPowerofFour(int n, int ind, int sum) {
        if (n == sum)
            return true;
        if (n < sum)
            return false;
        return checkPowerofFour(n, ind + 1, (int) Math.pow(4, ind));
    }

    public static void main(String[] args) {
        int i=0;
        while (i<=31)
        {
            System.out.println((int) Math.pow(3,i++));
        }
        Power_of_Four a = new Power_of_Four();
        System.out.println(a.isPowerOfFour(256));
    }
}
