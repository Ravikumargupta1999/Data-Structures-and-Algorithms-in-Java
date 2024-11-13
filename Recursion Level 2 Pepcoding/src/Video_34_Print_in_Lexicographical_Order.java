import java.util.ArrayList;
import java.util.List;

public class Video_34_Print_in_Lexicographical_Order {
    // https://www.youtube.com/watch?v=gRo86WqFYSE&list=PLcg9PGsf43LgHt0T0-k3Rn3NyxBSxBtA0&index=5
    public static void main(String[] args) {
        int n = 100;
        for (int i = 1; i <= 9; i++)
            dfs(i, n);
    }

    static void dfs(int i, int n) {
        if (i > n)
            return;
        System.out.print(i + "  ");
        for (int j = 0; j < 10; j++)
            dfs(10 * i + j, n);
    }

    // https://leetcode.com/problems/lexicographical-numbers/submissions/
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if( n < 10)
        {
            for (int i=1;i<= n;i++){
                list.add(i);
            }
            return list;
        }
        for (int i=1;i<10;i++)
            DFS(i,n,list);
        return list;

    }
    static void DFS(int i, int n,ArrayList<Integer> list)  {
        if (i > n)
            return;
        list.add(i);
        for (int j = 0; j < 10; j++)
            DFS(10 * i + j, n,list);
    }
}
