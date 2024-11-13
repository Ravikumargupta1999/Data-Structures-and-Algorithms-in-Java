public class Maximum_Subset_XOR {
    public static int maxSubarrayXOR(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.println(arr[i] ^ arr[j]);
                if ((arr[i] ^ arr[j]) > max) {
                    max = (arr[i] ^ arr[j]);
                }
                System.out.println();
            }

        }
        return max;
    }
        public static void main (String[]args){
            int n = 11;
            int arr[] = {1, 2, 3,4,5, 6, 22, 33,44, 22, 111};
            System.out.println(maxSubarrayXOR(arr, n));
        }
    }
