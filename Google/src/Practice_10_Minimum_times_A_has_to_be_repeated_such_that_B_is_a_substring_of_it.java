

//https://practice.geeksforgeeks.org/problems/5ef42ba605fff6cd60b1b2dd2ee230ade1fa25b0/1/?company[]=Google&company[]=Google&difficulty[]=1&page=4&query=company[]Googledifficulty[]1page4company[]Google
//https://leetcode.com/problems/repeated-string-match/submissions/
public class Practice_10_Minimum_times_A_has_to_be_repeated_such_that_B_is_a_substring_of_it {
    static int minRepeats(String A, String B) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(A);
        int count = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            count++;
        }
        String temp = sb.toString();
        if (temp.contains(B))
            return count;
        temp += A;
        if (temp.contains(B))
            return ++count;
        return -1;
    }
}
