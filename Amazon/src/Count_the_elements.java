import java.util.Arrays;
//https://practice.geeksforgeeks.org/problems/count-the-elements1529/1/?company[]=Amazon&company[]=Amazon&page=3&category[]=Hash&query=company[]Amazonpage3company[]Amazoncategory[]Hash

public class Count_the_elements {
    public static int[] find(int a[], int b[], int q[]) {
        Arrays.sort(b);
        int[] ans = new int[q.length];
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        for (int i = 0; i < q.length; i++) {
            int index = FloorNumber(b, a[q[i]]);
            // System.out.println(q[i] + "  " +(index+1));
            ans[i] = index + 1;

        }
        return ans;

    }

    public static int FloorNumber(int[] arr, int target) {
        // System.out.println(target);
        if (arr[0] > target)
            return -1;
        int start = 0;
        int ans = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid])
                end = mid - 1;

            else if (target > arr[mid])
                start = mid + 1;

            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return end;


    }

    public static void main(String[] args) {
        int n = 6;
        int a[] = {1, 2, 3, 4, 3, 4};
        int b[] = {0, 4, 2, 5, 51, 4};
        int[] q = {5, 3};
        System.out.println(Arrays.toString(find(a, b, q)));
    }
}
//    For Input:
//        6
//        1 2 3 4 7 9
//        0 4 2 4 51 4
//        2
//        5
//        4