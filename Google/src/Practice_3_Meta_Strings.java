public class Practice_3_Meta_Strings {
    // https://practice.geeksforgeeks.org/problems/meta-strings5713/1
    boolean metaStrings(String s1, String s2) {


        if (s1.length() != s2.length())
            return false;
        int[] arr = new int[26];
        for (char ch : s1.toCharArray())
            arr[ch-'a']++;
        for (char ch : s2.toCharArray())
            arr[ch-'a']--;
        for (int num : arr)
            if(num != 0)
                return false;
        int count = 0;
        for (int i = 0; i < s1.length(); i++)
            if (s1.charAt(i) != s2.charAt(i))
                count++;
        if (count == 2)
            return true;
        else
            return false;
    }
}
