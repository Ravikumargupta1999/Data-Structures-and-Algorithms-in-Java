class Solution{
    static int findSingle(int n, int arr[]){
        int val = 0;
        for(int uni : arr)
            val = val ^ uni;
        return val;
    }
}
// https://practice.geeksforgeeks.org/problems/alone-in-couple5507/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=-2&page=1&query=category[]Bit%20Magicdifficulty[]-2page1category[]Bit%20Magic
