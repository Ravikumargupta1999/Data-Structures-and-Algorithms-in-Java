package Day_7_Linked_List_Array;

import java.util.Stack;

// https://leetcode.com/problems/trapping-rain-water/submissions/
public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        stack.add(-1);

        for (int i = 0; i < height.length; i++) {
            left[i] = stack.peek();
            if (height[i] > stack.peek()) {
                stack.add(height[i]);
            }
        }

        int[] right = new int[n];
        stack = new Stack<>();
        stack.add(0);
        for (int i = n - 1; i >= 0; i--) {
            right[i] = stack.peek();
            if (height[i] > stack.peek()) {
                stack.add(height[i]);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            if (min > height[i]) {
                res += (min - height[i]);
            }
        }
        return res;
    }

    // https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=43
    public int trap1(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;

        while (l <= r){
            if(height[l] <= height[r]){
                if(leftMax <= height[l]){
                    leftMax = height[l];
                }else {
                    res += (leftMax-height[l]);
                }
                l++;
            }else {
                if(rightMax <= height[r]){
                    rightMax = height[r];
                }else {
                    res += (rightMax-height[r]);
                }
                r--;
            }
        }
        return res;
    }

}
