public class Linked_List_Matrix {
    static class Node {
        int data;
        Node right, down;

        Node(int data) {
            this.data = data;
            right = null;
            down = null;
        }
    }
    //https://practice.geeksforgeeks.org/problems/linked-list-matrix/1/?category[]=Linked%20List&category[]=Linked%20List&page=1&query=category[]Linked%20Listpage1category[]Linked%20List

    static Node construct(int arr[][], int n) {
        if (n == 1) {
            Node root = new Node(arr[0][0]);
            return root;
        }
        Node root = new Node(arr[0][0]);
        root.right = new Node(arr[0][1]);
        root.down = new Node(arr[1][0]);
        explore(root.right, arr, 0, 1);
        explore(root.down, arr, 1, 0);
        return root;
    }

    static void explore(Node temp, int[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length)
            return;
        if (i + 1 < arr.length) {
            temp.down = new Node(arr[i + 1][j]);
            explore(temp.down, arr, i + 1, j);
        }
        if (j + 1 < arr.length) {
            temp.right = new Node(arr[i][j + 1]);
            explore(temp.right, arr, i, j + 1);
        }

    }

    public static void main(String[] args) {

    }
}
