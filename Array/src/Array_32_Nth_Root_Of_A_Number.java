public class Array_32_Nth_Root_Of_A_Number {
    public int NthRoot(int n, int m) {
        int low = 0;
        int high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int temp = (int) Math.pow(mid, n);
            if (temp == m)
                return mid;
            else if (temp < m)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
