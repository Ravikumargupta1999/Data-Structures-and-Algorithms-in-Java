package Sumit_Malik_Level_2;

public class V_Video_8_Find_element_that_appears_once_while_all_other_elements_appear_twice {
    // https://practice.geeksforgeeks.org/problems/element-appearing-once2552/1
//    https://leetcode.com/problems/single-number/
    public static int search(int[] A, int N) {
        int ans = 0;
        for (int a : A)
            ans ^= a;
        return ans;
    }
}
