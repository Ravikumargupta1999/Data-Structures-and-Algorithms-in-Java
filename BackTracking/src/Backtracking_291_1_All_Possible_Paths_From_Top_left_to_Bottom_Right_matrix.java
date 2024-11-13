import java.util.ArrayList;

public class Backtracking_291_1_All_Possible_Paths_From_Top_left_to_Bottom_Right_matrix {
    public static void printAllPaths(int row, int col) {
        int[][] arr = new int[row][col];
        int val = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = val++;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        go(arr, al, 0, 0, row - 1, col - 1);

    }

    public static void go(int[][] arr, ArrayList<Integer> al, int x, int y, int r, int c) {
        if (x > r || y > c) {
            return;
        }
        al.add(arr[x][y]);
        if (x == r  && y == c ) {

            for (int i = 0; i < al.size(); i++) {
                System.out.print(al.get(i) + "  ");
            }
            System.out.println("");

        }
        go(arr, al, x + 1, y, r, c);
        go(arr, al, x, y + 1, r, c);
        al.remove(al.size() - 1);
    }

    public static void main(String[] args) {
        printAllPaths(3, 3);
    }
}
