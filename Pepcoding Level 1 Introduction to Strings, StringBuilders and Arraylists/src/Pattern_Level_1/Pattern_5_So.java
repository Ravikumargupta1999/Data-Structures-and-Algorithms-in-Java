package Pattern_Level_1;

public class Pattern_5_So {
    public static void main(String[] args) {
        int n = 5;
        int sp = n / 2;
        int st = 1;
        for (int i = 1; i <= n; i++) {
            printSpace(sp);
            printStar(st);
            System.out.println("");
            if (i <= n / 2) {
                sp--;
                st += 2;
            } else {
                sp++;
                st -= 2;
            }

        }
    }

    public static void printSpace(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("\t");
        }

    }

    public static void printStar(int total) {
        for (int i = 1; i <= total; i++) {
            System.out.print("*\t");
        }

    }
}
