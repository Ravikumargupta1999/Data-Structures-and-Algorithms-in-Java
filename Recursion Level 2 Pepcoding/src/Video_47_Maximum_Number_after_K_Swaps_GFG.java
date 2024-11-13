public class Video_47_Maximum_Number_after_K_Swaps_GFG {
    // https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1


    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k) {
        findMaximumNum1(str, k);
        return max;
    }
    //Function to find the largest number after k swaps.
    static String max;
    public static void findMaximumNum1(String str, int k) {
//        java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:1838)
//        at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        if (Double.parseDouble(str) > Double.parseDouble(max)) {
            max = str;
        }
        if (k == 0)
            return;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                str = swap(str, i, j);
                findMaximumNum1(str, k - 1);
                str = swap(str, i, j);
            }
        }
    }

    static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);
        return str.substring(0, i) + jth + str.substring(i + 1, j) + ith + str.substring(j + 1);
    }

    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        String st = "9223372036854775807";
        System.out.println(st.length());
        System.out.println(Double.toString(Double.MAX_VALUE).length());
    }
//    static String max;
    public static String findMaximumNum2(String str,int k)
    {
        max = str;
        findMaximum2(str.toCharArray(), k);
        return max;
    }

    static void findMaximum2(char[] str,int k)
    {

        if (k == 0)
            return;

        int n = str.length;


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
                    findMaximum2(str, k - 1);


                    char c = str[i];
                    str[i] = str[j];
                    str[j] = c;
                }
            }
        }
    }
}
