import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class OOo {



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minimumOperations(TreeNode root) {
        int ans = 0;
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            int size = queue.size();

            ArrayList<Integer> arr = new ArrayList<>();
            while (size-- > 0){
                TreeNode temp = queue.poll();
                arr.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
            ans += minSwaps(arr);
        }
        return ans;
    }
    class Pair {
        int val;
        int idx;

        public Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int minSwaps(ArrayList<Integer> nums) {
        int n = nums.size();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums.get(i), i);
        }
        Arrays.sort(arr, (a, b) -> {
            return a.val - b.val;
        });
        int ans = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] || arr[i].idx == i)
                continue;
            int clen = 0;
            int j = i;
            while (!vis[j]) {
                vis[j] = true;
                clen++;
                j = arr[j].idx;
            }
            ans += (clen - 1);
        }
        return ans;

    }
}
