public class Elements_in_the_Range {
   // https://practice.geeksforgeeks.org/problems/elements-in-the-range2834/1?page=16&company[]=Amazon&sortBy=submissions

    boolean check_elements(int[] arr, int n, int A, int B) {
        boolean[] flag = new boolean[B - A + 1];
        for(int ele : arr)
        {
            if(ele >= A && ele <= B)
                flag[ele-'A'] = true;
        }
        for(boolean f : flag)
            if(!f)
                return false;
        return true;
    }
}
