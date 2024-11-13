public class Practice_2_Third_Largest_Element {
    // https://practice.geeksforgeeks.org/problems/third-largest-element/1?page=8&company[]=Amazon&sortBy=submissions

    static int thirdLargest(int[] arr, int n) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > first) {
                int f1 = first;
                int f2 = second;
                int f3 = third;

                first = val;
                second = f1;
                third = f2;
            } else if (val > second) {
                int f2 = second;
                int f3 = third;

                second = val;
                third = f2;
            } else if (val > third) {
               third = val;
            }
        }
        return third == Integer.MIN_VALUE ? -1 : third;
    }

    public static void main(String[] args) {
        int[] arr = {5};
        System.out.println(thirdLargest(arr,arr.length));
    }

}
