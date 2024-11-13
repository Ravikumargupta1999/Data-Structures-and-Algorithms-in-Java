public class Exceptionally_odd {
    int getOddOccurrence(int[] arr, int n) {
        int val = 0;
        for(int uni : arr)
            val = val ^ uni;
        return val;
    }
}
// https://practice.geeksforgeeks.org/problems/find-the-odd-occurence4820/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=-1&page=2&query=category[]Bit%20Magicdifficulty[]-1page2category[]Bit%20Magic
