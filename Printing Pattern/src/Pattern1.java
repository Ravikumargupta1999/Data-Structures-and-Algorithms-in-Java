public class Pattern1 {
    public static void fun(int n) {

        int count = 1;
        for (int j = 1; j <= n; j++) {
            int i = 1;
            int temp = count;
            while (temp-- > 0) {
                System.out.print((i++) + " ");
            }
            count++;
            System.out.println("");
        }

    }

    public static void main(String[] args) {
        fun(5);
    }
}
