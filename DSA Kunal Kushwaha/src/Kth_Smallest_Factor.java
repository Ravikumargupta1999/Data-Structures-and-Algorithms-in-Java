public class Kth_Smallest_Factor {
    public static void main(String[] args) {
        System.out.println(kThSmallestFactor(566, 6));
    }
    //https://practice.geeksforgeeks.org/problems/kth-smallest-factor2345/1
    // O(sqrt(n))
    static int kThSmallestFactor(int n, int k) {
        if(k < 1)
            return -1;
        int count = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.println(i);
                    count += 1;
                } else {
                    System.out.println(i+"  "+n/i);
                    count += 2;
                }
            }
        }
        System.out.println(count);
        if (k > count)
            return -1;
        int temp = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    temp += 1;
                    if (temp == k)
                        return i;
                } else {
                    temp += 1;
                    if (k == temp)
                        return i;
                    else if (k == count - temp + 1)
                        return n/i;
                }
            }
        }
        return -1;

    }
}
