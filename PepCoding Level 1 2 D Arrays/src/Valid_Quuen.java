import java.util.HashSet;
import java.util.Scanner;

public class Valid_Quuen {
    public static String QueenCheck(String[] strArr) {
        String str1 = strArr[0];
        String str2 = strArr[1];
        int x1 = 0;
        int y1 = 0;
        int x2 = 0;
        int y2 = 0;
        boolean first = false;
        x1 = Character.getNumericValue(str1.charAt(1)) - 1;
        y1 = Character.getNumericValue(str1.charAt(3)) - 1;
        x2 = Character.getNumericValue(str2.charAt(1)) - 1;
        y2 = Character.getNumericValue(str2.charAt(3)) - 1;

        boolean[][] queen = new boolean[8][8];
        queen[x2][y2] = true;
        if (IsQueenSafe(queen, x1, y1)) {

            return "-1";
        } else {
            int val = -5;
            HashSet<Integer> set = new HashSet<>();
            val = IsQueenSafe1(queen, x1, x2);
            if (val > 0)
                 set.add(val);
            val = IsQueenSafe2(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe3(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe4(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe5(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe6(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe7(queen, x1, x2);
            if (val > 0)
                set.add(val);
            val = IsQueenSafe8(queen, x1, x2);
            if (val > 0)
                set.add(val);
            int min = 9;
            for (int temp : set)
            {
                min = Math.min(temp,min);
            }

            if(min == 9)
                return "-1";
            else
                return Integer.toString(min);
        }

    }

    public static int IsQueenSafe1(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe2(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe3(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe4(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;

    }

    public static int IsQueenSafe5(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j < chess.length && i < chess.length; i++, j++) {

            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe6(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; i < chess.length; i++) {

            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe7(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j >= 0 && i < chess.length; i++, j--) {

            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }

    public static int IsQueenSafe8(boolean[][] chess, int row, int col) {
        int step = 0;
        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j]) {
                return step;
            }
            step++;
        }
        return -1;
    }


    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i >= 0; i--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length && i >= 0; i--, j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length; j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j < chess.length && i < chess.length; i++, j++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; i < chess.length; i++) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j >= 0 && i < chess.length; i++, j--) {
            if (chess[i][j])
                return false;
        }

        for (int i = row, j = col; j >= 0; j--) {
            if (chess[i][j])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner s= new Scanner(System.in);
//        System.out.print(QueenCheck(s.nextLine());
        System.out.println(QueenCheck(new String[]{ "(8,2)", "(7,1)" }));
    }
}
