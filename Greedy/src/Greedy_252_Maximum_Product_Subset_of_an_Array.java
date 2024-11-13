public class Greedy_252_Maximum_Product_Subset_of_an_Array {
    // https://www.geeksforgeeks.org/maximum-product-subset-array/
    // https://www.youtube.com/watch?v=QLUg9v5NJc0
    public static int findMaxProduct(int n, int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        }
        int mod = 1000000007;
        int negProduct = 1;
        int zero = Integer.MIN_VALUE;
        int posProduct = Integer.MIN_VALUE;

        int neg_count = 0;
        int neg_min = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                zero = 0;
                continue;
            }

            if (arr[i] < 0) {
                neg_count += 1;
                neg_min = Math.max(neg_min, arr[i]);

                long p = (long) negProduct * arr[i];
                negProduct = (int) (p % mod);

                continue;
            }

            if (posProduct == Integer.MIN_VALUE) {
                posProduct = arr[i];
            } else {
                long p = (long) posProduct * arr[i];
                posProduct = (int) (p % mod);
            }
        }

        System.out.println(neg_count + "   " + neg_min + "     " + negProduct);
        System.out.println(zero);
        System.out.println(posProduct);
        System.out.println("\n");

        if (neg_count == 0) { // means there is no negative Integer..either 0 or positive
            return Math.max(posProduct, zero);
        }

        if (neg_count == 1) { // if there is only one negative integer, then we cannot add this to ur product
            return Math.max(negProduct, Math.max(posProduct, zero));
        }

        // if we are reaching here means there are surely 2 or more than negaitive integer

        if (posProduct == Integer.MIN_VALUE) {
            posProduct = 1;
        }

        if (neg_count % 2 != 0) { // means there is one extra negative..if we remove that then negative product would be positive
            negProduct = (negProduct / neg_min) % mod;
        }

        long product = (long) negProduct * posProduct;
        return (int) (product % mod);

    }

    public static void main(String[] args) {
        int[] arr = {-1, 0};
        System.out.println(findMaxProduct(arr.length, arr));
    }
}