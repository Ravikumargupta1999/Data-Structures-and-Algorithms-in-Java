public class Staircase {
    public static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            int space = n - i;
            while (space-- > 0){
                System.out.print("  ");
            }
            int k = i;
            while (k-- > 0)
                System.out.print("# ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        staircase(4);
    }
}
