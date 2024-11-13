import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/sliding-puzzle/
public class Video_9_Sliding_Puzzle {
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList<>();
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        System.out.println(sb);
        int[][] swapIndex = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {4, 2}};
        queue.add(initial);
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        while (queue.size() > 0) {
            int size = queue.size();
            while (size-- > 0) {
                String rem = queue.poll();
                if (rem.equals(target))
                    return level;

                int idx = -1;
                for (int i = 0; i < rem.length(); i++) {
                    if (rem.charAt(i) == '0') {
                        idx = i;
                        break;
                    }
                }
                int[] swap = swapIndex[idx];
                for (int i = 0; i < swap.length; i++) {
                    String tobeAdded = swapCharacter(rem, idx, swap[i]);
                    if (visited.contains(tobeAdded))
                        continue;
                    queue.add(tobeAdded);
                    visited.add(tobeAdded);
                }
            }
            level++;
        }
        return -1;
    }

    public String swapCharacter(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}
