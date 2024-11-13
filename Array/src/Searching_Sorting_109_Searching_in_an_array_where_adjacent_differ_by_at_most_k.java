public class Searching_Sorting_109_Searching_in_an_array_where_adjacent_differ_by_at_most_k {
    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 7, 7, 6 };
        int x = 6;
        int k = 2;
        int n = arr.length;
        int Arr = Search(arr, n, x, k);
        System.out.println(Arr);
    }

    public static int Search(int[] arr, int n, int x, int k) {
        int ans = -1;
        int i = 0;
        while (i < n) {
            if (arr[i] == x) {
                ans = i;
                break;
            }
            int y = Math.max(1, Math.abs(arr[i] - x) / k);
            i = i + y;
        }
        return ans;
    }
}
