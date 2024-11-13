import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/finding-position2223/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=12&query=company[]Amazondifficulty[]0page12company[]Amazon#

public class Finding_Position {
    static long nthPosition(long n) {
        int result = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++)
            res.add(i + 1);
        System.out.println(res);
        int count = 1;
        while (true) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < res.size() - 1; i += 2) {
                if (i != res.size() - 1)
                    al.add(res.get(i + 1));
            }
            if (al.size() == 1) {
                return al.get(0);
            }
            res = al;
            count++;
            if (count == n)
                break;
        }
        return n;
    }

    static long nthPosition1(long n) {
        long x =  (long) (Math.log(n) / Math.log(2));;
        long res = (long) Math.pow(2, x);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(nthPosition1(11));
    }
}
