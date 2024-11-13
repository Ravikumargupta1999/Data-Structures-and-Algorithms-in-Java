public class A_Trie_6_Count_Pairs_With_XOR_in_a_Range {
    class Node {
        Node left;
        Node right;
        int count;
    }

    public int getCount(Node root) {
        return (root == null) ? 0 : root.count;
    }

    int MAX_BIT = 15;

    public void insert(Node root, int val) {
        for (int i = 14; i >= 0; i--) {
            int mask = 1 << i;
            int bit = (val & (mask)) > 0 ? 1 : 0;
            if (bit == 0) {
                if (root.left == null)
                    root.left = new Node();
                root = root.left;
            } else {
                if (root.right == null)
                    root.right = new Node();
                root = root.right;
            }
            root.count++;
        }
    }

    public int query(Node root, int high, int val, int index) {
        if (root == null)
            return 0;
        if (index == -1)
            return getCount(root);
        int bitV = (val & (1 << index)) > 0 ? 1 : 0;
        int bitH = (high & (1 << index)) > 0 ? 1 : 0;
        if (bitV == 0) {
            if (bitH == 0)
                return query(root.left, high, val, index - 1);
            else
                return getCount(root.left) + query(root.right, high, val, index - 1);
        } else {
            if (bitH == 0)
                return query(root.right, high, val, index - 1);
            else
                return getCount(root.right) + query(root.left, high, val, index - 1);
        }
    }

    public int countPairs(int[] arr, int low, int high) {
        Node root = new Node();
        int count = 0;
        for (int val : arr) {
            count += query(root, high, val, MAX_BIT - 1);
            count -= query(root, low - 1, val, MAX_BIT - 1);
            insert(root, val);
        }
        return count;
    }
}
