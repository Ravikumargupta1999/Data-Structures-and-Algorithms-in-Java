public class Find_the_Difference {
    // https://leetcode.com/problems/find-the-difference/
    public char findTheDifference(String s, String t) {
        int[] frq1 = new int[26];
        for (char ch : s.toCharArray())
            frq1[ch-'a']++;
        int[] frq2 = new int[26];
        for (char ch : t.toCharArray())
            frq2[ch-'a']++;
        for (int i=0;i<26;i++){
            if(frq2[i]-frq1[i] ==1)
                return (char)( 'a'+i);
        }
        return ' ';
    }
}
