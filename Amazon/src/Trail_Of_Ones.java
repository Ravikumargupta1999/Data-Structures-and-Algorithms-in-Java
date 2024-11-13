import java.math.BigInteger;

// https://practice.geeksforgeeks.org/problems/trail-of-ones3242/1

public class Trail_Of_Ones {
    static int numberOfConsecutiveOnes(int n){
        int count =0;
        int j = (int)Math.pow(2,n)-1;
        for(int i = 0; i<=j;i++)
        {
            String str = Binary(i);
            if(doesContainConsecutiveOne(str))
                count++;
        }
        return count;
    }
    public static boolean doesContainConsecutiveOne(String str)
    {
        for(int i=0;i<str.length()-1;i++)
            if(str.charAt(i) == '1' && str.charAt(i+1) == '1')
                return true;
        return false;
    }
    public static String Binary(int n)
    {
        StringBuilder str = new StringBuilder();
        while (n > 0)
        {
            if(n % 2 == 0)

                str.insert(0,"0");
            else
                str.insert(0,"1");
            n = n/2;
        }
        return str.toString();

    }

    public static void main(String[] args) {
        System.out.println(numberOfConsecutiveOnes(5));
    }
}
