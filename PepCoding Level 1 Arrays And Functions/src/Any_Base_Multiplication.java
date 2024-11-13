public class Any_Base_Multiplication {
    // https://practice.geeksforgeeks.org/problems/subtraction-and-two-numbers0816/1#
    public static void main(String[] args) {
        System.out.println(345* 2115);
        System.out.println(getProduct(10, 345, 2115));
    }

    static int getProduct(int b, int n1, int n2) {
        int ans = 0;
        int p = 1;
        while (n2 > 0) {
            int d2 = n2 % 10;
            n2 = n2 / 10;
            int sprd = getProductWithSingleDigit(b, n1, d2);
            ans = getSum(b, ans, sprd * p);
            p = p * 10;
        }
        return ans;
    }

    static int getProductWithSingleDigit(int b, int n1, int d2) {
        int ans = 0;
        int c = 0;
        int p = 1;
        while (n1 > 0 || c > 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;
            int d = (d1 * d2) + c;
            c = d / b;
            d = d % b;
            ans = ans + (d * p);
            p = p * 10;
        }
        return ans;
    }

    static int getSum(int b, int n1, int n2) {
        int p = 1;
        int ans = 0;
        int c = 0;
        while (n1 > 0 || n2 > 0 || c > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1 / 10;
            n2 = n2 / 10;
            int d = d1 + d2 + c;
            c = d / b;
            d = d % b;
            ans += (d * p);
            p = p * 10;
        }
        return ans;
    }
}
