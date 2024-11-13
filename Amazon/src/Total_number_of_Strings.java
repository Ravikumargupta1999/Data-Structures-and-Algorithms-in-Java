//https://practice.geeksforgeeks.org/problems/total-number-of-strings5726/1/?category[]=Mathematical&category[]=Mathematical&company[]=Amazon&company[]=Amazon&page=3&query=category[]Mathematicalcompany[]Amazonpage3company[]Amazoncategory[]Mathematical#
// https://www.youtube.com/watch?v=v6x0EnLlqUc
public class Total_number_of_Strings {
    public static int no_ofString(int n) {
        int p = 1000000007;
        int ans = 1;
        System.out.println(ans);
        ans = (ans + (2 * n) % p)%p;
        System.out.println(ans);
        ans = (ans + (n)*(n-1) % p)%p;
        System.out.println(ans);
        ans = (ans + (((n)*(n-1))/2) % p)%p;
        System.out.println(ans);
        ans = (ans + (((n)*(n-1)*(n-2))/2) % p)%p;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(no_ofString(16148));
    }
}
