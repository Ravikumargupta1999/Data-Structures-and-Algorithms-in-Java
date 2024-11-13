public class Count_Square_Sum_Triples {
    public int countTriples(int n) {
        int count = 0;
        for (int c = 1; c <= n; c++) {
            for (int a = 1; a < n; a++) {
                for (int b = 1; b < c; b++) {
                    if(a != b && a != c && (a*a + b*b) == c*c)
                        count++;
                }
            }
        }
        return count;
    }
}
