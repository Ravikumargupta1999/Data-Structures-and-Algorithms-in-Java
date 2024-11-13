// https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon

public class Bitonic_Point {
    static int findMaximum(int[] a, int n) {

        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == a.length - 1)
                return a[mid];
            else if (mid == 0)
                return a[0];
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1])
                return a[mid];
            else if (a[mid] > a[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {

    }
}
