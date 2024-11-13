//https://practice.geeksforgeeks.org/problems/next-sparse-binary-number0029/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0company[]Amazonpage5#

public class Next_Sparse_Binary_Number {
    public static int nextSparse(int n)
    {
        while (true)
        {
            String str = Binary(n);
            if(isSparse(str))
                return n;
            else
                n++;
        }
    }
    public static boolean isSparse(String str)
    {
        for(int i=1 ;i<str.length();i++)
        {
            if(str.charAt(i) == '1')
                if(str.charAt(i-1) == '1')
                    return false;

        }
        return true;
    }

    public static String Binary(int n)
    {
        String str = "";
        while (n > 0)
        {
            if(n % 2 == 0)
                str = "0" + str;
            else
                str = "1" + str;
            n = n/2;
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(Binary(15));
        System.out.println(nextSparse(5));
    }
}
