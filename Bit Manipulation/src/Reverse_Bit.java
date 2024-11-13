public class Reverse_Bit {
    // pep coding
    public static void solution(int n)
    {

        boolean flag = false;
        int rev =0;
        int j = 0;
        for(int i=31;i>=0;i--)
        {
            int mask = ( 1 << i);
            if(flag)
            {
                //System.out.println(i+"  "+flag);
                if((n & mask) != 0)
                {
                    System.out.print(1);
                    int smask = ( 1 << j);
                    rev  |= smask;
                }
                else
                {
                    System.out.print(0);
                }
                j++;
            }
            else
            {
               // System.out.println(i+"  "+flag);
                if ( (n & mask ) != 0)
                {
                    flag = true;
                    System.out.print(1);
                    int smask = (1 <<j);
                    //System.out.println(smask+"   "+flag);
                    rev |= smask;
                    j++;
                }
            }
        }
        System.out.println("");
        System.out.println("");
        System.out.println(rev+"  ha");
    }
    public static void main(String[] args) {
        solution(1);

    }
}
