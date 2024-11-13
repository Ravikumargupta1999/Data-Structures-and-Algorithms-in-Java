//https://practice.geeksforgeeks.org/problems/check-set-bits5408/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=1&query=company[]Amazondifficulty[]-1page1company[]Amazon

public class Check_Set_Bits {
    static int isBitSet(int n) {
        if (n == 0)
            return 0;
        int i = 0;
        while (i < n) {
            // System.out.println((1<<i)-1);
            if ((1 << i) - 1 == n)
                return 1;
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(isBitSet(7));
    }
}
