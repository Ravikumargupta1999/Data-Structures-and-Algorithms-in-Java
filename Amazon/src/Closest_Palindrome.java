public class Closest_Palindrome {

    public static long closestPalindrome(long num)
    {
       if(num < 10)
           return num;
       if(isPalindrome(num))
           return num;
       long i = num - 1;
       long j = num + 1;
       while (i > 0 )
       {
           if(isPalindrome(i)  == true && isPalindrome(num) == true)
           {
               return i;
           }
           else if(isPalindrome(i))
               return i;
           else if(isPalindrome(j))
               return j;
           else
           {
               i = i-1;
               j = j+1;
           }
       }
        return i;
    }
    static boolean isPalindrome(long n)
    {

        int divisor = 1;
        while (n / divisor >= 10)
            divisor *= 10;

        while (n != 0)
        {
            long leading = n / divisor;
            long trailing = n % 10;
            if (leading != trailing)
                return false;
            n = (n % divisor) / 10;
            divisor = divisor / 100;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(closestPalindrome(489));
    }
}
