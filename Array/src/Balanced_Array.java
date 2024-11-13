public class Balanced_Array {
    long minValueToBalance(long a[] ,int n)
    {
        long left_sum = 0;
        for(int i=0;i<n/2;i++)
            left_sum = left_sum + a[i];
        long right_sum = 0;
        for(int i=n/2;i<n;i++)
            right_sum = right_sum+ a[i];
        return Math.abs(right_sum-left_sum);

    }
    public static void main(String[] args) {

    }
}
// https://practice.geeksforgeeks.org/problems/balanced-array07200720/1/?category[]=Arrays&category[]=Arrays&difficulty[]=-1&page=1&query=category[]Arraysdifficulty[]-1page1category[]Arrays
