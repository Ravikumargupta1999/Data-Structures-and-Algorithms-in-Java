public class Rotate_Array {
    static void rotateArr(int arr[], int d, int n) {
        if (d == 0)
            return;
        while (d-- > 0) {
            int temp = arr[n - 1];
            arr[n - 1] = arr[0];
            for (int i = n - 2; i >= 0; i--) {
                int val = arr[i];
                arr[i] = temp;
                temp = val;
            }
        }
    }
}
// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=2&query=company[]Amazondifficulty[]0page2company[]Amazon
