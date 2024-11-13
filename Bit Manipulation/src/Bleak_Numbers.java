public class Bleak_Numbers {
    public int is_bleak(int n)
    {
        for(int i= n;i>=0;i--)
            if(i + setBit(i) == n)
                return 0;
        return 1;
    }
    static int setBit(int n) {
        int count = 0;
        while (n > 0) {
            n -= (n & -n);
            count++;
        }

        return count;
    }
}
// https://practice.geeksforgeeks.org/problems/bleak-numbers1552/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=1&page=1&query=category[]Bit%20Magicdifficulty[]1page1category[]Bit%20Magic
//