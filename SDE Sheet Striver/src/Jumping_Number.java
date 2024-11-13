public class Jumping_Number {
    public static void main(String[] args) {
        System.out.println(jumpingNums(50));
    }
    static long jumpingNums(long X) {

        while (X-- > 0) {
            String temp = Long.toString(X + 1);

            for (int i = 0; i < temp.length()-1; i++) {

                if(Math.abs(temp.charAt(i) - temp.charAt(i+1)) != 1)
                    break;
                if(i == temp.length()-2)
                    return X+1;
            }
        }
        return -1;
    }
}
