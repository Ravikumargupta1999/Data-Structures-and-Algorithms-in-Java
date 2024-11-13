public class Squares_In_Chessboard {
    static Long squaresInChessBoard(Long n) {
        return (n * (n + 1) / 2) * (2 * n + 1) / 3;
    }

}
