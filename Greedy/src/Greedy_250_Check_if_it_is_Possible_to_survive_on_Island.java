public class Greedy_250_Check_if_it_is_Possible_to_survive_on_Island {
    // https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1/
    // youtube.com/watch?v=Wq4Sn20dHr8&t=174s
    static int minimumDays(int S, int N, int M) {
        int requiredFood = M * S;
        int foodWeCanGet = (S - (S / 7)) * N;

        if (requiredFood > foodWeCanGet)
            return -1;
        else if (requiredFood % N == 0)
            return requiredFood / N;
        else
            return requiredFood / N + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumDays(10, 16, 2));
    }
}
