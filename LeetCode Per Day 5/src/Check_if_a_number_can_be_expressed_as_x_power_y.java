public class Check_if_a_number_can_be_expressed_as_x_power_y {
    public static void main(String[] args) {

        System.out.println(checkPower(27));
    }

    static int checkPower(int N) {
        int x = 1, y = 2;
        if (N == 1) {
            return 1;
        }
        for (int i = x; i < N; i++) {
            for (int j = y; j < N; j++) {
                if (Math.pow(i, j) == N) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
