import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Video_12_N_Queen_Branch_and_Bound {
    // https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[][] board = new boolean[n][n];
        boolean[] cols = new boolean[n];
        boolean[] ndig = new boolean[2 * n - 1];
        boolean[] rdiag = new boolean[2 * n - 1];
        solve(board,0,cols,ndig,rdiag,new ArrayList<>());
        Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for(int i=0;i<o1.size();i++)
                {
                    if(o1.get(i) != o2.get(i))
                        return o1.get(i) - o2.get(i);
                }
                return o1.get(0) - o2.get(0);
            }
        });

        return ans;
    }
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndig, boolean[] rdig,ArrayList<Integer> al) {
        if (row == board.length) {
            ans.add(new ArrayList<>(al));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!cols[col] && !ndig[row + col] && !rdig[row - col + board.length - 1]) {
                cols[col] = true;
                ndig[row + col] = true;
                rdig[row - col + board.length - 1] = true;
                al.add(col+1);
                solve(board, row + 1, cols, ndig, rdig, al);
                al.remove(al.size()-1);
                cols[col] = false;
                ndig[row + col] = false;
                rdig[row - col + board.length - 1] = false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(nQueen(8));
    }
}
