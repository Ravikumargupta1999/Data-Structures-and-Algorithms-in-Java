public class Array39_Palindromic_Array {
    // https://practice.geeksforgeeks.org/problems/palindromic-array-1587115620/1
    public static int palinArray(int[] a, int n) {
        int i;
        for (i = 0; i < a.length; i++) {
            int n1, r, sum = 0, temp;
            n1 = a[i];
            temp = n1;
            while (n1 > 0) {
                r = n1 % 10;
                sum = (sum * 10) + r;
                n1 = n1 / 10;
            }

            if (temp != sum)
                break;
        }
        if (i > a.length - 1)
            return 1;
        else
            return 0;
    }
}
