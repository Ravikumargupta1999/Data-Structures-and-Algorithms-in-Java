package Day1;

public class Spiral_Matrix_IV {
    // https://leetcode.com/problems/spiral-matrix-iv/submissions/
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int num = 0;
        int minRow = 0;
        int maxRow = m - 1;
        int minCol = 0;
        int maxCol = n - 1;
        int i;
        int j;
        while (num <= m * n) {
            if (num == m * n) {
                break;
            }

            for (i = minRow, j = minCol; j <= maxCol; j++) {
                if (num == m* n) {
                    break;
                }
                matrix[i][j] = head == null ? -1 : head.val;
                head = head == null ? null:head.next;
                num++;
            }
            minRow++;
            for (i = minRow, j = maxCol; i <= maxRow; i++) {
                if (num == m * n) {
                    break;
                }
                matrix[i][j] = head == null ? -1 : head.val;
                head = head == null ? null:head.next;
                num++;
            }
            maxCol--;

            for (i = maxRow, j = maxCol; j >= minCol; j--) {
                if (num == m * n) {
                    break;
                }
                matrix[i][j] = head == null ? -1 : head.val;
                head = head == null ? null:head.next;
                num++;
            }
            maxRow--;

            for (i = maxRow, j = minCol; i >= minRow; i--) {
                if (num == m * n) {
                    break;
                }
                matrix[i][j] = head == null ? -1 : head.val;
                head = head == null ? null:head.next;
                num++;
            }
            minCol++;
        }
        return matrix;
    }
}
