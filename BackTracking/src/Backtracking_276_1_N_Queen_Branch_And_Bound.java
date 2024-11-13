import java.util.*;

public class Backtracking_276_1_N_Queen_Branch_And_Bound {
    // https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1/#
    // https://www.youtube.com/watch?v=yvt0emtFiIE

    static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    static boolean[] cols, leftDiagonal, rightDiagonal;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        cols = new boolean[n];
        leftDiagonal = new boolean[2 * n];
        rightDiagonal = new boolean[2 * n];
        result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            temp.add(0);
        solveNQUtil(result, n, 0, temp);
        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });

        return result;
    }

    private static void solveNQUtil(ArrayList<ArrayList<Integer>> result, int n, int row, ArrayList<Integer> comb) {
        if (row == n) {
            result.add(new ArrayList<>(comb));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || leftDiagonal[row + col] || rightDiagonal[row - col + n])
                continue;
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = true;
            comb.set(col, row + 1);
            solveNQUtil(result, n, row + 1, comb);
            cols[col] = leftDiagonal[row + col] = rightDiagonal[row - col + n] = false;
        }
    }


    public static void main(String[] args) {
        int n = 8;
        ArrayList<ArrayList<Integer>> res = nQueen(n);
        System.out.println(res.size());
        System.out.println(res);
    }
}

