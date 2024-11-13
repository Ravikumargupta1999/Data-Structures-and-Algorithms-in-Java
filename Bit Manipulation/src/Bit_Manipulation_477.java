public class Bit_Manipulation_477 {
    static int findPosition(int n) {
        int temp = n;
        int pos = 0;
        int count = 0;
        while (n > 0) {
            n -= (n & -n);
            count++;
        }
        if(count != 1)
            return -1;
        else
            return getBinaryRep(temp);

    }
    static int getBinaryRep(int n){

        String str = "";
        while (n >= 1)
        {
            if(n % 2 == 0)
            {
                str  = 0 + str;
            }
            else
            {
                str = 1 + str;
            }
            n = n/2;
        }
        int count = 0;
        int l = str.length();
        for(int i = str.length() -1; i>=0;i--)
        {
            if(str.charAt(i) == '1')
            {
                count++;
                return count;
            }
            else
                count++;
        }

        return -1;
    }
}
