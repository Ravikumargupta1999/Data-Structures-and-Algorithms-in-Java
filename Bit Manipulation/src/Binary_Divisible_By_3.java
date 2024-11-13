public class Binary_Divisible_By_3 {
    int isDivisible(String s) {
       int even = 0;
       int odd = 0;
       for(int i=0;i<s.length();i++)
       {
           int bit = s.charAt(i) - '0';
           if(i % 2 == 0)
               even += bit;
           else
               odd += bit;
       }
       int delta = even - odd;
       if(delta % 11 == 0)
           return 1;
       else
           return 0;
    }
    int isDivisible1(String str) {
        char[] c = str.toCharArray();
        int size = c.length;

        char state = '0';

        for (int i = 0; i < size; i++) {

            // storing binary digit
            char digit = c[i];

            switch (state) {

                // when state is 0
                case '0':
                    if (digit == '1')
                        state = '1';
                    break;

                // when state is 1
                case '1':
                    if (digit == '0')
                        state = '2';
                    else
                        state = '0';
                    break;

                // when state is 2
                case '2':
                    if (digit == '0')
                        state = '1';
                    break;
            }
        }

        // if final state is 0th state
        if (state == '0')
            return 1;
        return 0;
    }

    public static void main(String[] args) {

    }

}
