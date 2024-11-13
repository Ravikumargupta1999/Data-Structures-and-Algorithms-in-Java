package Pattern_Level_1;

public class Pattern_9 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == n - i + 1 || j == i)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println("");

        }
    }
}
