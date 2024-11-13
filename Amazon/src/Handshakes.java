import java.util.HashMap;
//https://practice.geeksforgeeks.org/problems/handshakes1303/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=9&query=company[]Amazondifficulty[]1page9company[]Amazon#
// https://www.youtube.com/watch?v=YGsmvcQzpxs
public class Handshakes {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static int count(int n)
    {
//        System.out.println(n);
        if(map.containsKey(n))
            return map.get(n);
        if( n == 0)
            return 1;
        if( n % 2 == 1)
            return 0;
        int sum = 0;
        for(int i=0;i<n;i+=2)
        {
            sum += count(i)*count(n-2-i);
        }
        map.put(n,sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(count(30));
    }
}
