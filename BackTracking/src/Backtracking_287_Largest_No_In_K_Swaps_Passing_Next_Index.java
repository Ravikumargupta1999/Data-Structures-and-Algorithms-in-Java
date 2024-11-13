public class Backtracking_287_Largest_No_In_K_Swaps_Passing_Next_Index {
    // https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1#
    // https://www.youtube.com/watch?v=GstuPf5u3lg&t=253s
    static String max;
    public static String findMaximumNum(String str,int k)
    {
        max = str;
        findMaximum(str.toCharArray(), k,0);
        return max;
    }

    static void findMaximum(char[] str,int k,int index)
    {

        int n = str.length;
        if (k == 0)
            return;

        for (int i = index; i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (str[i] < str[j])
                {
                    char t = str[i];
                    str[i] = str[j];
                    str[j] = t;

                    if (String.valueOf(str).compareTo(max) > 0)
                        max = String.valueOf(str);

                    findMaximum(str, k - 1,i+1); // perform k-1 swaps from i+1 index

                    char c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }
        }
    }
}
