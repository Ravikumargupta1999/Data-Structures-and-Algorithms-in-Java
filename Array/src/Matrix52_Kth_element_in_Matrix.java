// Done
import java.util.Collections;
import java.util.PriorityQueue;
public class Matrix52_Kth_element_in_Matrix {
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/submissions/868099792/
    // https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1#
    public static int KSmallest(int[][] matrix, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }

    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        priorityQueue.add(new int[]{mat[0][0], 0, 0});
        while (k-- > 1) {
            int[] rem = priorityQueue.poll();
//            System.out.println(Arrays.toString(rem));
            int newRow = rem[1] + 1;
            int newCol = rem[2];
            if (rem[1] + 1 < n && mat[newRow][newCol] != -1) {
                priorityQueue.add(new int[]{mat[newRow][newCol], newRow, newCol});

                // Mark cell visited
                mat[newRow][newCol] = -1;
            }
            newRow = rem[1];
            newCol = rem[2] + 1;
            if (rem[2] + 1 < n && mat[newRow][newCol] != -1) {
                priorityQueue.add(new int[]{mat[newRow][newCol], newRow, newCol});
                // mark cell visited
                mat[newRow][newCol] = -1;
            }
        }
        return priorityQueue.peek()[0];
    }

}
