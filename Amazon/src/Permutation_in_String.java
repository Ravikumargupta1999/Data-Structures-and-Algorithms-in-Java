import java.util.Arrays;

public class Permutation_in_String {
    public long findRank(String s)
    {
        long[] fact = new long[26];
        fact[0] = 1;
        fact[1] = 1;
        for(int i=2;i<fact.length;i++)
        {
            fact[i] = i*fact[i-1];
        }
        int[] arr = new int[256];
        int n = s.length();

        for(int i=0;i<n;i++)
        {
            arr[s.charAt(i)]++;
        }
        for(int j=0;j<256;j++)
        {
            if(arr[j] > 1)
                return 0;
        }

        int numberOfLetterSmaller = 0;
        long output = 0;
        for(int i = 0;i<n;i++)
        {
           numberOfLetterSmaller = 0;
            String str = "";
            for(int j=0;j<256;j++)
            {
                if( j == s.charAt(i))
                    break;
                if(arr[j] == 1) {
                    numberOfLetterSmaller++;
                    str +=(char)(j)+"  ";
                }

            }
//            System.out.println(str);
            arr[s.charAt(i)] = 0;
//            System.out.println(i+"  "+ numberOfLetterSmaller+ "   "+(long) numberOfLetterSmaller*fact[n-1-i]);
            output += (numberOfLetterSmaller*fact[n-1-i]);
        }
        return output+1;
    }

    public static void main(String[] args) {
        String str = "";
        for(int i=0;i<26;i++)
        {
            str += (char)(97+i)+"  ";
        }
//        System.out.println(str);
        Permutation_in_String a = new Permutation_in_String();
        System.out.println(a.findRank("vsrtkjpre"));

    }

}
