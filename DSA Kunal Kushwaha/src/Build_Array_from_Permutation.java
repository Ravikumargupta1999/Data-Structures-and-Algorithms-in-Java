public class Build_Array_from_Permutation {
    public int[] buildArray(int[] arr) {
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            ans[i] = arr[arr[i]];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
