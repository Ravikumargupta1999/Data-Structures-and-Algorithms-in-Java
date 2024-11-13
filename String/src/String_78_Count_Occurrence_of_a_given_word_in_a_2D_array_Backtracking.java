public class String_78_Count_Occurrence_of_a_given_word_in_a_2D_array_Backtracking {
    //    // https://practice.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1/#
    public int findOccurrence(char ch[][], String str)
    {
        int ans = 0;
        int size = str.length();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                ans += solve(ch, i, j, str, size, 0);
            }
        }
        return ans;
    }

    public static int solve(char[][] ch, int i, int j, String str, int size, int idx) {
        int found = 0;
        if (i >= 0 && j >= 0 && i < ch.length &&  j < ch[0].length && str.charAt(idx) == ch[i][j]) {
            char temp = str.charAt(idx);
            ch[i][j] = '0';
            idx += 1;
            if (idx == size){
                ch[i][j] = temp;
                return 1;
            }
            else {
                found += solve(ch, i + 1, j, str, size, idx);
                found += solve(ch, i - 1, j, str, size, idx);
                found += solve(ch, i, j + 1, str, size, idx);
                found += solve(ch, i, j - 1, str, size, idx);
            }
            ch[i][j] = temp;
        }
        return found;
    }
    public static void main(String[] args) {
        String str = "MAGIC";
        char[][] ch = {
                {'B', 'B', 'M', 'B', 'B', 'B'},
                {'C', 'M', 'A', 'G', 'I', 'C'},
                {'I', 'B', 'G', 'B', 'B', 'I'},
                {'G', 'B', 'I', 'B', 'B', 'G'},
                {'A', 'B', 'C', 'B', 'B', 'A'},
                {'M', 'C', 'I', 'G', 'A', 'M'}
        };
//        System.out.println(CountString(ch, str));
    }

}
