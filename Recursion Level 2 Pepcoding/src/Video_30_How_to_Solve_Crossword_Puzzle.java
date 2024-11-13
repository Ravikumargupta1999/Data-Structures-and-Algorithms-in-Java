import java.util.Scanner;

// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/crossword-puzzle-official/ojquestion
// https://www.youtube.com/watch?v=fUAZS-sdP2Q&list=PL-Jc9J83PIiHO9SQ6lxGuDsZNt2mkHEn0&index=29
public class Video_30_How_to_Solve_Crossword_Puzzle {
    public static void solution(char[][] arr, String[] words, int vIdx) {
        if (vIdx == words.length) {
            print(arr);
            return;
        }
        String word = words[vIdx];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == '-' || arr[i][j] == word.charAt(0)) {
                    if (canPlacedHorizontally(arr, word, i, j)) {
                        boolean[] wePlaced = placedWordHorizontally(arr, word, i, j);
                        solution(arr, words, vIdx + 1);
                        unplacedWordHorizontally(arr, wePlaced, i, j);
                    }
                    if (canPlacedVertically(arr, word, i, j)) {
                        boolean[] wePlaced = placedWordVertically(arr, word, i, j);
                        solution(arr, words, vIdx + 1);
                        unplacedWordVertically(arr, wePlaced, i, j);
                    }
                }
            }
        }

    }

    public static boolean canPlacedHorizontally(char[][] arr, String word, int i, int j) {
        if (j - 1 >= 0 && arr[i][j - 1] != '+') {
            return false;
        } else if (j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') {
            return false;
        }
        for (int jj = 0; jj < word.length(); jj++) {
            if (j + jj >= arr[0].length)
                return false;
            if (arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj))
                continue;
            else
                return false;
        }
        return true;
    }

    public static boolean canPlacedVertically(char[][] arr, String word, int i, int j) {
        if (i - 1 >= 0 && arr[i - 1][j] != '+') {
            return false;
        } else if (i + word.length() < arr.length && arr[i + word.length()][j] != '+') {
            return false;
        }
        for (int ii = 0; ii < word.length(); ii++) {
            if (i + ii >= arr.length)
                return false;
            if (arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii))
                continue;
            else
                return false;
        }
        return true;
    }

    public static boolean[] placedWordHorizontally(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj < word.length(); jj++) {
            if (arr[i][j + jj] == '-') {
                arr[i][jj + j] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
        return wePlaced;
    }

    public static boolean[] placedWordVertically(char[][] arr, String word, int i, int j) {
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii < word.length(); ii++) {
            if (arr[i + ii][j] == '-') {
                arr[i + ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
        return wePlaced;
    }

    public static void unplacedWordHorizontally(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int jj = 0; jj < wePlaced.length; jj++) {
            if (wePlaced[jj]) {
                arr[i][jj + j] = '-';
            }
        }
    }

    public static void unplacedWordVertically(char[][] arr, boolean[] wePlaced, int i, int j) {
        for (int ii = 0; ii < wePlaced.length; ii++) {
            if (wePlaced[ii]) {
                arr[i + ii][j] = '-';
            }
        }
    }


    public static void print(char[][] arr) {
        for (char[] ar : arr) {
            for (char ch : ar) {
                System.out.print(ch);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char[][] arr = new char[10][10];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            arr[i] = str.toCharArray();
        }
        int n = scn.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < words.length; i++) {
            words[i] = scn.next();
        }
        solution(arr, words, 0);
    }
}
