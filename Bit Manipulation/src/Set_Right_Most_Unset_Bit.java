import org.omg.Messaging.SYNC_WITH_TRANSPORT;
// https://practice.geeksforgeeks.org/problems/set-the-rightmost-unset-bit4436/1#
public class Set_Right_Most_Unset_Bit {
    static int setBit(int n){
      String str = Integer.toBinaryString(n);
      int j ;
      int i = 0;
      for(j = str.length()-1;j>=0;j--) {
          i++;
          if (str.charAt(j) == '0')
              break;
      }
      int result = (1 << (i-1));
      String val  = Integer.toBinaryString(n|result);
      int val1 = Integer.parseInt(val);
      int val2 = Integer.parseInt(str);
      return getDecimal(val1) | getDecimal(val2);

    }
    public static int getDecimal(int binary) {
        int decimal = 0;
        int n = 0;
        while (true) {
            if (binary == 0) {
                break;
            } else {
                int temp = binary % 10;
                decimal += temp * Math.pow(2, n);
                binary = binary / 10;
                n++;
            }
        }
        return decimal;
    }

        public static void main(String[] args) {
        System.out.println(setBit(21));
    }
}
