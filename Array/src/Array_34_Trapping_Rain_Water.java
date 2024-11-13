import java.util.PriorityQueue;

public class Array_34_Trapping_Rain_Water {

    //https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#
//https://www.youtube.com/watch?v=UZG3-vZlFM4
// https://leetcode.com/problems/trapping-rain-water/submissions/867915055/
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(arr[i], left[i - 1]);
        }
        right[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (Math.min(left[i], right[i]) - arr[i]);
        }
        return count;
    }


    //    Container With Most Water
    // https://leetcode.com/problems/container-with-most-water/description/
    // https://practice.geeksforgeeks.org/problems/container-with-most-water0535/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public int maxArea(int[] arr) {
        int value = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = 0;
            temp = (j - i) * Math.min(arr[i], arr[j]);
            if (temp > value)
                value = temp;
            if (arr[i] < arr[j])
                i++;
            else
                j--;

        }
        return value;
    }

    // https://leetcode.com/problems/trapping-rain-water-ii/description/
    // https://www.youtube.com/watch?v=fywyCy6Fyoo
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.add(new Pair(i, j, heightMap[i][j]));
                    vis[i][j] = true;
                }

            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int water = 0;
        while (pq.size() > 0) {
            Pair rem = pq.remove();
            for (int[] dir : dirs) {
                int rowdash = rem.row + dir[0];
                int coldash = rem.col + dir[1];
                if (rowdash >= 0 && rowdash < m && coldash >= 0 && coldash < n && vis[rowdash][coldash] == false) {
                    water += Math.max(0, rem.height - heightMap[rowdash][coldash]);
                    if (heightMap[rowdash][coldash] >= rem.height) {
                        pq.add(new Pair(rowdash, coldash, heightMap[rowdash][coldash]));
                    } else {
                        pq.add(new Pair(rowdash, coldash, rem.height));
                    }
                    vis[rowdash][coldash] = true;
                }
            }
        }
        return water;
    }

    public class Pair implements Comparable<Pair> {
        int row;
        int col;
        int height;

        public Pair(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Pair o) {

            return this.height - o.height;
        }

    }


    // 1 2 3
    // 4 5 6
    //   8  3 7
    //


    public String multiply(String num1, String num2) {
        int temp = 0;
        StringBuilder s1 = new StringBuilder("");
        for (int i = num2.length() - 1; i >= 0; i--) {

            int p1 = Integer.parseInt(num2.charAt(i) + "");

            StringBuilder s2 = new StringBuilder("");
            int k = temp;

            while (k-- > 0)
                s2.append(0);
            int carry = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {

                int p2 = Integer.parseInt(num1.charAt(j) + "");

                int res = p1 * p2 + carry;

                s2.append(res % 10);
                carry = res / 10;
            }
            if (carry > 0)
                s2.append(carry);
            // System.out.println(s2);
            temp++;

            StringBuilder s3 = new StringBuilder("");
            int a = 0;
            int b = 0;
            carry = 0;
            while (a < s1.length() || b < s2.length()) {
                int res = a < s1.length() ? Integer.parseInt(s1.charAt(a) + "") : 0;
                res += (b < s2.length() ? Integer.parseInt(s2.charAt(b) + "") : 0);
                res += carry;
                s3.append(res % 10);
                carry = res / 10;
                a++;
                b++;
            }
            if (carry > 0)
                s3.append(carry);
            s1 = s3;
        }
        s1.reverse();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '0')
                return s1.toString();
        }
        return "0";
    }

    //    https://leetcode.com/problems/product-of-array-except-self/description/
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[nums.length];

        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = nums[i] * left[i - 1];
        }

        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        int[] res = new int[n];
        res[0] = right[1];
        res[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            res[i] = left[i - 1] * right[i + 1];
        }
        return res;
    }
}
