public class Magic_Number {
    public static int nthMagicNumber(int n) {
        int ans = 0;
        int base = 5;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += (last * base);
            base = base * 5;
        }
        return ans;
    }
    static Long nthFaithfulNum(int n) {
        long ans = 0;
        long base = 7;
        while (n > 0) {
            int last = n & 1;
            n = n >> 1;
            ans += (last * base);
            base = base * 5;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(nthMagicNumber(5));
    }
}
