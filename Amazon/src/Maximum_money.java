//https://practice.geeksforgeeks.org/problems/maximum-money2855/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=1&query=company[]Amazondifficulty[]-1page1company[]Amazon

public class Maximum_money {
    static int maximizeMoney(int n , int k) {
        int inc = k;
        int exc = 0;
        for(int i= 1;i<n;i++)
        {
            int ninc = exc + k;
            int nexc = Math.max(inc,exc);
            inc = ninc;
            exc = nexc;
        }
        return Math.max(inc,exc);
    }

    public static void main(String[] args) {
        System.out.println(maximizeMoney(5,10));
    }
}
