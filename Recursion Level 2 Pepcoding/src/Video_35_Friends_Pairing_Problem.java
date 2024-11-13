public class Video_35_Friends_Pairing_Problem {
    // https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1
    public static void main(String[] args) {
        int n = 4;
//        solution(1, n, new boolean[n + 1], "");
        System.out.println(new Video_35_Friends_Pairing_Problem().countFriendsPairings(n));
    }

    static int count = 1;

    public static void solution(int i, int n, boolean[] used, String asf) {
        if (i > n) {
            System.out.println(count + "." + asf);
            count++;
            return;
        }
        if (used[i])
            solution(i + 1, n, used, asf);
        else {
            used[i] = true;
            solution(i + 1, n, used, asf + "(" + i + ") ");
            for (int j = i + 1; j <= n; j++) {
                if (!used[j]) {
                    used[j] = true;
                    solution(i + 1, n, used, asf + "(" + i + "," + j + ") ");
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }
    long val;
    public long countFriendsPairings(int n)
    {
        val  = 0;
        friendsPair(1,n,new boolean[n+1]);
        return val;
    }
    public  void friendsPair(int i, int n, boolean[] used) {
        if (i > n) {
            val++;
            return;
        }
        if (used[i])
            friendsPair(i + 1, n, used);
        else {
            used[i] = true;
            friendsPair(i + 1, n, used);
            for (int j = i + 1; j <= n; j++) {
                if (!used[j]) {
                    used[j] = true;
                    friendsPair(i + 1, n, used);
                    used[j] = false;
                }
            }
            used[i] = false;
        }
    }

}
