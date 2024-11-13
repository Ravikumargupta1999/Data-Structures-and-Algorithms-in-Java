//https://leetcode.com/problems/single-element-in-a-sorted-array/
//https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1
public class Video_35_Find_the_element_that_appears_once_in_sorted_array {
    static int findOnce(int arr[], int m) {
        int n = arr.length;
        int li = 0;
        int hi = n - 1;
        if (n == 1)
            return arr[0];
        if (n == 3) {
            if (arr[0] == arr[1])
                return arr[2];
            else
                return arr[0];
        } else if (arr[0] != arr[1])
            return arr[0];
        else if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int ans = 0;
        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (li == hi)
                return arr[li];


            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];

            else if (arr[mid] == arr[mid - 1]) {
                int lc = li - mid + 1;
                if (lc % 2 == 0)
                    li = mid + 1;
                else {
                    hi = mid - 2;
                }
            } else if (arr[mid] == arr[mid + 1]) {
                int rc = hi - mid + 1;
                if (rc % 2 == 0)
                    hi = mid - 1;
                else
                    li = mid + 2;

            } else
                return arr[mid];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 7, 7, 11, 11, 12};
        for (int i = 0; i < arr.length; i++)
            System.out.print(i + "    ");
        System.out.print("\n");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "    ");
        System.out.print("\n\n\n");
        System.out.println(findOnce(arr, arr.length));
    }
}
