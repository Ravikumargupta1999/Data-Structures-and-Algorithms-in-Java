public class Concatenation_of_Array {
    public int[] getConcatenation(int[] arr) {
        int[] ans = new int[2*arr.length];
        for(int i=0;i<arr.length;i++)
        {
          ans[i] =  arr[i];
        }
        int k = 0;
        for(int i= arr.length;i<ans.length;i++)
        {
            ans[i] = arr[k++];
        }
        return ans;
    }
}
