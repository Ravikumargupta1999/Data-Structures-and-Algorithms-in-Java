public class onvert_to_Base_2 {
    public static String baseNeg2(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            if (n % 2 == 0)
                sb.insert(0, 0);
            else
                sb.insert(0, 1);
            n = n / -2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(baseNeg2(3));
    }
}
