public class Frequency_Of_Digit {
    public static void main(String[] args) {
        System.out.println(getFrequency(64782246,2));
    }
    static int getFrequency(int n,int digit) {
        int count = 0;
        while (n > 0)
        {
            if(digit == n%10)
                count++;
            n = n /10;
        }
        return count;
    }
}
