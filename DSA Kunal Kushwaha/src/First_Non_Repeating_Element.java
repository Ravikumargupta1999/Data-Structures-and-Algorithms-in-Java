// https://leetcode.com/problems/single-number/submissions/
public class First_Non_Repeating_Element {
    public static int nonRepeating(int[] arr)
    {
        int val = 0;
        for(int x : arr)
            val = val ^ x;
        return val;
    }
    public static void main(String[] args) {
        int[] arr ={9,9,6};
        System.out.println(nonRepeating(arr));
    }
}
