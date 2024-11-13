public class Octal_To_Decimal {
    public static void main(String[] args) {
        int ans = 0;
        int power = 1;
        int num = 7014;
        while (num > 0) {
            int digit = num % 10;
            num = num / 10;
            ans += (power) * digit;
            power *= 8;
        }
        System.out.println(ans);
    }
}
