package InterviewQuestion;

public class Video_90_Rank_The_Permutation {
    // https://practice.geeksforgeeks.org/problems/rank-the-permutations2323/1
//    https://www.youtube.com/watch?v=Yat41hRCKlE
    static int rank(String S){
        int modulo = 1000003;
        int n = S.length();
        int[] arr = new int[26];
        for (char ch : S.toCharArray()) {
            arr[ch - 'a']++;
            if (arr[ch - 'a'] > 1)
                return 0;
        }

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = ((fact[i - 1] % modulo) * (i % modulo)) % modulo;
        }

        int res = 1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < S.charAt(i) - 'a'; j++) {
                count += arr[j];
            }
            arr[S.charAt(i) - 'a']--;
            res = res % modulo + ((count) * (fact[n - 1 - i])%modulo);
        }
        return res % modulo;
    }

}
