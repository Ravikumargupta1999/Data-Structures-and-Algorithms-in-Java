import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/clone-a-binary-tree/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon
// https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
// https://www.youtube.com/watch?v=lPAeiLyXwfY
public class Clone_a_Binary_Tree {
    class Tree {
        int data;
        Tree left, right, random;

        Tree(int d) {
            data = d;
            left = null;
            right = null;
            random = null;
        }
    }

    public Tree cloneTree(Tree tree) {
        if (tree == null)
            return null;
        HashMap<Tree, Tree> map = new HashMap<>();
        Tree root = get_Root_of_Copied_tree(tree, map);
        connect_random_nodes(tree, root,map);
        return root;
    }

    public Tree get_Root_of_Copied_tree(Tree root, HashMap<Tree, Tree> map) {
        if (root == null)
            return null;
        Tree node = new Tree(root.data);
        map.put(root, node);
        node.left = get_Root_of_Copied_tree(root.left, map);
        node.right = get_Root_of_Copied_tree(root.right, map);
        return node;
    }

    void connect_random_nodes(Tree root,Tree clone ,HashMap<Tree, Tree> map) {
        if (clone == null)
            return;
        clone.random = map.get(root.random);
        connect_random_nodes(root.left,clone.left, map);
        connect_random_nodes(root.right,clone.right, map);
    }
}
