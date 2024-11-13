import java.util.ArrayList;
import java.util.Collections;

public class Print_all_nodes_that_dont_have_sibling {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    ArrayList<Integer> ans = new ArrayList<>();

    ArrayList<Integer> noSibling(Node root) {
        if (root == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-1);
            return arrayList;
        }
        if (root.left == null || root.right == null) {
            if (root.left == null)
                ans.add(root.right.data);
            else
                ans.add(root.left.data);
        }
        getSiblings(root.left);
        getSiblings(root.right);
        if (ans.size() == 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-1);
            return arrayList;
        }
        Collections.sort(ans);
        return ans;
    }

    void getSiblings(Node root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null && root.right != null) {
            getSiblings(root.left);
            getSiblings(root.right);
        } else if (root.left == null) {
            ans.add(root.right.data);
            getSiblings(root.right);
        } else {
            ans.add(root.left.data);
            getSiblings(root.left);
        }
    }
}
