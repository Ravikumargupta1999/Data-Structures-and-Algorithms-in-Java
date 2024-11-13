import java.util.ArrayList;

public class Paths_from_root_with_a_specified_sum {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    // https://practice.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1/?difficulty[]=1&page=2&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Adobe&company[]=Flipkart&company[]=Goldman%20Sachs&category[]=Tree&query=difficulty[]1page2company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Adobecompany[]Flipkartcompany[]Goldman%20Sachscategory[]Tree#

    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        if (root == null) {
            ArrayList<Integer> al = new ArrayList<>();
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            if (root.data == sum) {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(sum);
                ans.add(al);
                return ans;
            }
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(root.data);
        findSum(root.left, arrayList1, root.data, sum);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(root.data);
        findSum(root.right, arrayList2, root.data, sum);
        return ans;
    }

    public static void findSum(Node root, ArrayList<Integer> al, int total, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            al.add(root.data);
            if (total + root.data == sum) {
                ans.add(new ArrayList<>(al));
            }
            al.remove(al.size() - 1);
            return;
        }
        al.add(root.data);
        if (total + root.data == sum) {
            ans.add(new ArrayList<>(al));
        }
        findSum(root.left, al, total + root.data, sum);
        findSum(root.right, al, total + root.data, sum);
        al.remove(al.size() - 1);
    }
}
