public class INiven_Numbers {
    static int checkNivenNumber(int n)
    {
        int val = n;
        int ans = 0;
        while (val >0)
        {
            int temp =  val%10;
            ans += (temp);
            val = val / 10;
        }
        if(n % ans == 0)
            return n / ans;
        else
            return 0;

    }

    public static void main(String[] args) {
        System.out.println(checkNivenNumber(4678));
    }
}
