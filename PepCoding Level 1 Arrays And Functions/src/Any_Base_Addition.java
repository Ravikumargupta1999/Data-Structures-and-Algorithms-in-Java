public class Any_Base_Addition {
    static int getSum(int n1, int n2, int b) {
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

    public static void main(String[] args) {
        System.out.println(getSum(12, 45, 10));
    }
}
