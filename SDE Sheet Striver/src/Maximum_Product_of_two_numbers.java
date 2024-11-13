public class Maximum_Product_of_two_numbers {
    // https://practice.geeksforgeeks.org/problems/maximum-product-of-two-numbers2730/1?page=23&company[]=Amazon&sortBy=submissions
    int maxProduct(int[] arr, int n) {
        int num1 = -1;
        int num2 = -1;
        if (arr[0] < arr[1]) {
            num1 = arr[1];
            num2 = arr[0];
        } else {
            num1 = arr[0];
            num2 = arr[1];
        }
        for (int i = 2; i < n; i++) {
            int num = arr[i];
            if (num >= num1) {
                num2 = num1;
                num1 = num;
            } else if (num > num2)
                num2 = num;
        }
        return num1 * num2;
    }
}
