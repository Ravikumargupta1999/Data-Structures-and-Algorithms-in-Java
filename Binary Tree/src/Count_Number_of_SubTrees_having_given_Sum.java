public class Count_Number_of_SubTrees_having_given_Sum {
    // https://practice.geeksforgeeks.org/problems/count-number-of-subtrees-having-given-sum/1/?difficulty[]=1&page=1&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Adobe&company[]=Flipkart&company[]=Goldman%20Sachs&category[]=Tree&query=difficulty[]1page1company[]Amazoncompany[]Microsoftcompany[]Googlecompany[]Adobecompany[]Flipkartcompany[]Goldman%20Sachscategory[]Tree#
    class Node
    {
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    int count = 0;
    int countSubtreesWithSumX(Node root, int sum)
    {
        findSubTrees(root, sum);
        return count;
    }

    public int findSubTrees(Node root, int sum) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null){
            if( root.data == sum)
                count++;
            return root.data;
        }
        int leftCount = findSubTrees(root.left, sum);
        int rightCount = findSubTrees(root.right, sum);
        if (leftCount + rightCount + root.data == sum) {
            count++;
        }
        return leftCount + rightCount + root.data;
    }
}
