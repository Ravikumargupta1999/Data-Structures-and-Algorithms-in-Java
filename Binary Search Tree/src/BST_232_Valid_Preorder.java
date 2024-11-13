import java.io.*;
import java.util.*;

public class BST_232_Valid_Preorder {
    // https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/
    static int canRepresentBST(int arr[], int N) {
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
