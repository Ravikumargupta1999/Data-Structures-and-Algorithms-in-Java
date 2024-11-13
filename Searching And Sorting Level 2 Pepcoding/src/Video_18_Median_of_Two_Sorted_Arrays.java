public class Video_18_Median_of_Two_Sorted_Arrays {

    // https://www.youtube.com/watch?v=xZed_DXZNoU&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=17
    public static double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        int lo = 0;
        int hi = a.length;
        int te = a.length + b.length;
        while (lo <= hi) {
            int aLeft = (lo + hi) / 2;
            int bLeft = (te + 1) / 2 - aLeft;

            int a1m1 = aLeft == 0 ? Integer.MIN_VALUE : a[aLeft - 1];
            int a1 = aLeft == a.length ? Integer.MAX_VALUE : a[aLeft];

            int b1m1 = bLeft == 0 ? Integer.MIN_VALUE : b[bLeft - 1];
            int b1 = bLeft == b.length ? Integer.MAX_VALUE : b[bLeft];

            if (a1m1 <= b1 && b1m1 <= a1) {
                double median ;
                if (te % 2 == 0) {
                    int leftMax = Math.max(a1m1, b1m1);
                    int rightMax = Math.min(a1, b1);
                    median = (leftMax + rightMax) / 2.0;
                } else {
                    int lefMax = Math.max(a1m1, b1m1);
                    median = lefMax;
                }
                return median;
            } else if (a1m1 > b1) {
                hi = aLeft - 1;
            } else if (b1m1 > a1) {
                lo = aLeft + 1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2, 3};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }
}
