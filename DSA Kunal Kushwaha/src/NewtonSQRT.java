public class NewtonSQRT {
    public static void main(String[] args) {
        System.out.println(sqrt(69));
    }

    static double sqrt(int n) {
        double x = n;
        double root;
        while (true) {
            root = 0.5 * (x + (n / x));
            if (Math.abs(root - x) < 1)
                break;
            x = root;
        }
        return root;
    }
}
