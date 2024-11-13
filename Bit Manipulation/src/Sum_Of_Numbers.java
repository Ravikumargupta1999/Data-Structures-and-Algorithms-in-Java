public class Sum_Of_Numbers {
    int sum(int x , int y)
    {
        while (y != 0)
        {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
}
//https://practice.geeksforgeeks.org/problems/sum-of-two-numbers-without-using-arithmetic-operators/1/?category[]=Bit%20Magic&category[]=Bit%20Magic&difficulty[]=0&page=1&query=category[]Bit%20Magicdifficulty[]0page1category[]Bit%20Magic
//https://www.youtube.com/watch?v=kIXhc8nZKIo