public class Find_Second_Largest_Element {
    // https://practice.geeksforgeeks.org/problems/find-second-largest-element2406/1/?page=4&company[]=Adobe&sortBy=submissions#
    public static int print2largest(int[] arr, int N) {
        int sl = Integer.MIN_VALUE;
        int fl = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val > fl) {
                sl = fl;
                fl = val;

            } else if (val < fl && val > sl) {
                sl = val;
            }
            // System.out.println(fl + "  " + sl);
        }
        // System.out.println(fl + "   " + sl);
        return sl == Integer.MIN_VALUE ? -1 : sl;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 6, 7};
        System.out.println(print2largest(arr, arr.length));
    }
}
