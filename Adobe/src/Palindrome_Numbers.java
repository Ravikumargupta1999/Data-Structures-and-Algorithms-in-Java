// https://practice.geeksforgeeks.org/problems/palindrome-numbers0942/1/?company[]=Adobe&company[]=Adobe&page=2&query=company[]Adobepage2company[]Adobe

public class Palindrome_Numbers {
    static long isPallindrome(long n) {
        String str = "";
        while (n >= 1)
        {
            if(n % 2 == 0)
            {
                str = '0' + str  ;
            }
            else
            {
                str = '1' + str;
            }
            n = n /2;
        }
        //System.out.println(str);
        long i = 0;
        long j = str.length()-1;
        while (i < (str.length()/2 + 1))
        {
            if(str.charAt((int) i) != str.charAt((int)j))
                return 0;
            i++;
            j--;
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPallindrome(1));
    }
}
