public class Backtracking_287_Largest_No_In_K_Swaps {
    // It will be passed just change to
    static String max;
    public static String findMaximumNum(String str,int k)
    {
        max = str;
        findMaximum(str.toCharArray(), k);
        return max;
    }

    static void findMaximum(char[] str,int k)
    {
        String s = new String(str);
        System.out.println(s);
        int n = str.length;
        if (k == 0)
            return;

        for (int i = 0; i < n - 1; i++)
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

                    findMaximum(str, k - 1);

                    char c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMaximumNum("9235",2));
    }
}
