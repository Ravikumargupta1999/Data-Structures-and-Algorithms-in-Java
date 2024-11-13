//https://practice.geeksforgeeks.org/problems/geek-and-coffee-shop5721/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=1&query=company[]Amazondifficulty[]-1page1company[]Amazon

public class Half_N_By_M {
    static int mthHalf(int n, int m){
        int step = 0;
        while (step < m-1)
        {
            n = n/2;
            step++;
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(mthHalf(10,5));
    }
}
