public class Decimal_To_Binary {
    public static void main(String[] args) {
        int num = 2;
        int ans = 0;
        int power = 1;
        while (num > 0) {
            int digit = num % 2;
            num /= 2;
            ans += (digit * power);
            power *= 10;
        }
        System.out.println(ans);
    }
}
