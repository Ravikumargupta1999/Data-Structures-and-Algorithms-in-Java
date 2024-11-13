import java.util.Arrays;
//https://leetcode.com/problems/count-of-smaller-numbers-after-self/
//https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/
//https://practice.geeksforgeeks.org/problems/count-smaller-elements2214/1/?company[]=Google&company[]=Google&difficulty[]=0&page=2&query=company[]Googledifficulty[]0page2company[]Google#

public class Count_Smaller_elements_Efficient {
    static class Node {
        int val;
        int count;
        Node left;
        Node right;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }

    }
    static Node root = null;
    static int[] constructLowerArray(int[] arr, int n) {
        int[] res = new int[n];

        Node root  = null;
//        for (int i = n - 1; i >= 0; i--) {
//            res[i] = addNode( ro,arr[i], 0);
//        }
//        System.out.println(Arrays.toString(res));
        return res;
    }

    public static int addNode( Node root,int value, int countSmaller) {

        if (root == null) {
            root = new Node(value, countSmaller);
            return countSmaller;
        }
        if (root.val < value) {
            return root.count + addNode(root.right, value, countSmaller + 1);
        } else {
            root.count++;
            return addNode(root.left, value, countSmaller);
        }
    }

    public static void main(String[] args) {


        int[] arr = {10, 6, 15, 20, 30, 5, 7 };
        arr = constructLowerArray(arr, arr.length);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
    }

}