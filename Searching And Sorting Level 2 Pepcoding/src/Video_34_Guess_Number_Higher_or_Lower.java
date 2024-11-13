public class Video_34_Guess_Number_Higher_or_Lower {
    // https://leetcode.com/problems/guess-number-higher-or-lower/submissions/
    // * Forward declaration of guess API.
//         * @param  num   your guess
//        * @return 	     -1 if num is lower than the guess number
//        *			      1 if num is higher than the guess number
//        *               otherwise return 0
//        * int guess(int num);
//        */
//
//public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int li = 1;
        int hi = n;
        int ans = -1;
        while (li <= hi) {
            int mid = li + (hi - li) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                li = mid + 1;
            else
                hi = mid - 1;
        }
        return ans;
    }

    int guess(int num) {
        return 0;
    }
}