
// Done
import java.util.HashMap;
// https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
public class Matrix53_Common_elements_in_all_rows_of_a_given_matrix {
    static void printCommonElements(int[][] matrix) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix[0].length; i++)
            map.put(matrix[0][i], 1);
        for (int i = 1; i < matrix.length; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (map.containsKey(matrix[i][j]))
                    temp.put(matrix[i][j], 1);
            }
            map = temp;
        }
        for (int val : map.keySet()) {
            System.out.print(val + "  ");
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 1, 7, 8},
                {3, 7, 8, 5, 1},
                {8, 7, 7, 3, 1},
                {8, 1, 2, 7, 9},
        };
        printCommonElements(arr);
    }

}
