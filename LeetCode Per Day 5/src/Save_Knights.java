public class Save_Knights {
    static long saveKnights(int n) {
        if (n == 2)
            return 4;
        else if (n % 2 == 0)
            return (long) Math.pow(n, 2) / 2;
        else
            return ((long) Math.pow(n, 2) + 1) / 2;
    }
}
