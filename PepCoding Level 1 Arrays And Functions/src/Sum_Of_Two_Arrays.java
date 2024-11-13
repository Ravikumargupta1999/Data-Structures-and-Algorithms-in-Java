public class Sum_Of_Two_Arrays {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 0, 7, 5};
        int[] arr2 = {1,1,1,1,1,1};
        System.out.println(sumOfArrays(arr1, arr2));
    }

    static int sumOfArrays(int[] arr1, int[] arr2) {
        int ans = 0;
        int carry = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int p = 1;
        while (i >= 0 || j >= 0 || carry >= 0) {
            int temp = 0;
            if (i >= 0 && j >= 0)
                temp = arr1[i] + arr2[j];
            else if (i >= 0)
                temp = arr1[i];
            else if (j >= 0) {
                temp = arr2[j];
            }
            temp = temp + carry;
            int d = temp % 10;
            ans = (ans) + (d * p);
            p = p * 10;
            carry = temp / 10;
            i--;
            j--;
            if (i < 0 && j < 0 && carry == 0)
                break;
        }
        return ans;
    }
}
