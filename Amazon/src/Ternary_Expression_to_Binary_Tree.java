public class Ternary_Expression_to_Binary_Tree {
    static class Node
    {
        char data;
        Node left, right;
        Node(char key)
        {
            data = key;
            left = right = null;
        }
    }
    public static Node convertExp(String str, int i)
    {
        if (i >= str.length())
            return null;
        Node root = new Node(str.charAt(i));
        ++i;
        System.out.println(i);
        if (i < str.length() && str.charAt(i) =='?')
            root.left = convertExp(str, i+1);
        else if (i < str.length())
            root.right = convertExp(str, i+1);

        return root;
    }
    public static void main(String[] args) {

    }
}
