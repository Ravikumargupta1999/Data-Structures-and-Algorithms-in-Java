import java.util.Stack;

public class BST_217_Valid_BST_From_Preorder {
//    https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/#
//    https://www.youtube.com/watch?v=GYdC4hQSo8A
    static int canRepresentBST(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > st.peek()) {
                root = st.pop();
            }
            if (arr[i] < root)
                return 0;
            st.push(arr[i]);
        }
        return 1;
    }
}
