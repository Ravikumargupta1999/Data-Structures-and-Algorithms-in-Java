public class A_Trie_5_Maximum_XOR_of_Two_Numbers_in_an_Array {
    // https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
    // 7ui
    // https://www.youtube.com/watch?v=OUNfpFswJq8&list=PL-Jc9J83PIiHgzR2UIDD7MI2ABIIZztON&index=5
    class Trie
    {
        public class Node
        {
            Node left , right;
        }
        Node root;
        Trie()
        {
            root = new Node();
        }
        public void insert(int val)
        {
            int bitIndex = 30;
            Node curr = root;
            while (bitIndex >= 0)
            {
                int mast = 1 << bitIndex;
                int bit = (mast & val) > 0 ? 1 : 0;
                if( bit == 0)
                {
                    if(curr.left == null)
                    {
                        curr.left = new Node();
                    }
                    curr = curr.left;
                }
                else {
                    if(curr.right == null)
                    {
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
                bitIndex--;
            }
        }
        public int query(int val)
        {
            int bitIndex = 30;
            Node curr = root;
            int ans = 0;
            while (bitIndex >= 0)
            {
                int mast = 1 << bitIndex;
                int bit = (mast & val) > 0 ? 1 : 0;
                if( bit == 0)
                {
                    if(curr.left != null)
                    {
                        curr = curr.left;
                    }
                    else
                    {
                        curr = curr.right;
                        ans |= mast;
                    }
                }
                else {
                    if(curr.right != null)
                    {
                        curr = curr.right;
                        ans |= mast;
                    }
                    else
                    {
                        curr = curr.left;
                    }
                }
                bitIndex--;
            }
            return ans;
        }
    }
    public  int findMaximumXOR(int[] arr)
    {
        Trie trie = new Trie();
        for (int val : arr)
        {
            trie.insert(val);
        }
        int max = 0;
        for(int val : arr)
        {
            int find = Integer.MAX_VALUE^val;
            int res = trie.query(find);
            max = Math.max(max,val^res);
        }
        return max;
    }
}
