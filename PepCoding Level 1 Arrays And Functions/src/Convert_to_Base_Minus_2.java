public class Convert_to_Base_Minus_2 {
    public static void main(String[] args) {
        int num = 2;
        int ans = 0;
        int power = 1;
        while (num > 0) {
            int digit = num % (-2);
            System.out.println(digit);
            num /= (-2);
            ans += (digit * power);
            power *= 10;
        }
        System.out.println(ans);
    }
}

