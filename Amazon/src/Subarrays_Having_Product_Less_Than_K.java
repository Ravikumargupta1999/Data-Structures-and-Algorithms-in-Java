// https://www.youtube.com/watch?v=NcD0CZLd6xM
// https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1/?category[]=Arrays&category[]=Arrays&difficulty[]=2&page=1&query=category[]Arraysdifficulty[]2page1category[]Arrays

public class Subarrays_Having_Product_Less_Than_K {
    public int countSubArrayProductLessThanK(long a[], long n, long k) {
        int count = 0;
        long i, j, mul;

        for (i = 0; i < n; i++) {
            if (a[(int) i] < k)
                count++;

            mul = a[(int) i];

            for (j = i + 1; j < n; j++) {
                mul = mul * a[(int) j];
                if (mul < k)
                    count++;
                else
                    break;
            }
        }

        return count;
    }

    public int countSubArrayProductLessThanK2(long a[], long n, long k) {
        long s = 0, e = 0, res = 0;
        long p = 1;

        for (e = 0; e < n; e++) {
            p *= a[(int) e];
            while (s < e && p >= k) {
                p /= a[(int) s];
                s += 1;
            }
            if (p < k) {
                long len = e - s + 1;
                res += len;
            }

        }

        return (int) res;
    }

}
