package Day_10_Recursion_and_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        List<List<String>> list = solveNQueens(8);
        System.out.println(list.size());
        System.out.println(list);

    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        printNQueen(0, n, list, res);
        return res;
    }

    public static void printNQueen(int currRow, int n, List<String> list, List<List<String>> res) {
        if (currRow == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i=0;i<n;i++){
            sb.append('.');
        }
        for (int col = 0; col < n; col++) {
            if (isValid(currRow,col,n,list)){
                sb.setCharAt(col,'Q');
                list.add(sb.toString());
                printNQueen(currRow+1,n,list,res);
                sb.setCharAt(col,'.');
                list.remove(list.size()-1);
            }
        }
    }

    public static boolean isValid(int row, int col, int n,List<String> list) {
        // left diagonal
        int i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
            i--;
            j--;
        }

        i = row - 1;
        j = col;
        while (i >= 0 && j >= 0) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
            i--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < n) {
            if (list.get(i).charAt(j) == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
}
