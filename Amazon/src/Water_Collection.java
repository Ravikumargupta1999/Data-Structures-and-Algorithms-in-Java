//https://practice.geeksforgeeks.org/problems/amount-of-water1348/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon

public class Water_Collection {
    static int maxWater(int arr[], int n) {
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = arr[0];
        int lmax = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = lmax;
            if (lmax < arr[i])
                lmax = arr[i];
        }
        right[n - 1] = arr[n - 1];
        int rmax = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = rmax;
            if (rmax < arr[i])
                rmax = arr[i];
        }
        int count = 0;
        for (int i = 1; i <= n - 2; i++) {
            if (left[i] >= arr[i] && right[i] >= arr[i])
                if (Math.min(left[i], right[i]) > arr[i])
                    count += (Math.min(left[i], right[i]) - arr[i]);
            System.out.println(i + "  " + left[i] + "  " + right[i] + "   " + arr[i] + "  " + count);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(maxWater(arr, arr.length));
    }
}
