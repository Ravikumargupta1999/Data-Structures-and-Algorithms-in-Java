public class Common_Subsequence {
    Boolean commonSubseq (String s1, String s2)
    {
        int[] arr = new int[26];
        for (char ch : s1.toCharArray())
            arr[ch-'A']++;
        for (char ch : s2.toCharArray()){
            if(arr[ch-'A'] > 0)
                return true;
        }
        return false;
    }
}
