/// https://practice.geeksforgeeks.org/problems/count-possible-ways-to-construct-buildings5007/1
// https://www.youtube.com/watch?v=0nF-BMYy7tc&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=19

public class Video_8_Arrange_Buildings {
    public static int TotalWays(int n) {
        // int p = 1000000007;
        int p = 1000000007;
        int ob = 1;
        int os = 1;
        int sum = ob + os;
        if (n == 1)
            return sum * sum;
        int i = 2;
        while (i <= n) {
            ob = os % p;
            os = sum % p;
            sum = os % p + ob % p;
            i++;
        }
        long val1 = sum;
        long val = val1 * val1;
        val = val % p;
        return (int) val;

    }


    public static void main(String[] args) {
        System.out.println(TotalWays(22));


    }
}
