public class Rectangles_in_N_N_Board {
    static Long rectanglesInChessBoard(Long n) {
        return ((n*(n+1))/2)*((n*(n+1))/2) - squaresInChessBoard(n);
    }
    static Long squaresInChessBoard(Long n) {
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;
    }


}
