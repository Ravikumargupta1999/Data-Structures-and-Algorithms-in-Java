package Sumit_Malik_Level_2;

// https://www.youtube.com/watch?v=NjcMT9wZHV0&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=4
// https://www.geeksforgeeks.org/josephus-problem-set-2-simple-solution-k-2/
// Special Case of Josephus problem
public class V_Video_4_Josephus_Problem_Special_Case {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(josephus(n));
    }

    static int josephus(int n) {
        int hp = powerOf2(n);
        int l = n - hp;
        return 2 * l + 1;
    }

    public static int powerOf2(int n) {
        int i = 1;
        while (i * 2 <= n)
            i = i * 2;
        return i;
    }
}
