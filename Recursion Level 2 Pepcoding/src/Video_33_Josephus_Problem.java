public class Video_33_Josephus_Problem {
    // Pep coding
    public static int solution(int n, int k) {
        if (n == 1)
            return 0;
        int x = solution(n-1,k);
        int y = (x + k) % n;
        return y;
    }



// https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1#

    static int safePos(int n, int k) {
        return 1 + safePos1(n,k);
    }
    static int safePos1(int n, int k) {
        if (n == 1)
            return 0;
        int x = safePos1(n-1,k);
        int y = (x + k) % (n);
        return y;
    }
    public static void main(String[] args) {
        System.out.println(safePos(1,3));
    }
}