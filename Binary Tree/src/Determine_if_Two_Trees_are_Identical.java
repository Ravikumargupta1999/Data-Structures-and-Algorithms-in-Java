import java.util.ArrayList;
// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=1&category[]=Tree&category[]=subset&query=company[]Amazondifficulty[]0page1company[]Amazoncategory[]Treecategory[]subset#
public class Determine_if_Two_Trees_are_Identical {

    class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //Function to check if two trees are identical.
    boolean isIdentical(Node root1, Node root2)
    {
        ArrayList<Integer> al1 = new ArrayList<>();
        preOrder(root1,al1);
        ArrayList<Integer> al2 = new ArrayList<>();
        preOrder(root2,al2);
        // System.out.println(al1);
        // System.out.println(al2);
        // if(al1.size() != al2.size())
        //     return false;
        // for(int i=0;i<al1.size();i++)
        // {
        //     if(al1.get(i) != al2.get(i))
        //         return false;
        // }
        return al1.equals(al2);
    }
    void preOrder(Node root,ArrayList<Integer> arrayList)
    {
        if(root == null)
            return;
        arrayList.add(root.data);
        preOrder(root.left,arrayList);
        preOrder(root.right,arrayList);
    }
}