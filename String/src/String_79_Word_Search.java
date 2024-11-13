public class String_79_Word_Search {
    // https://leetcode.com/problems/word-search/
    public boolean exist(char[][] ch, String str) {

        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[i].length; j++) {
                if (ch[i][j] == str.charAt(0) && dfs(ch, i, j, 0, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] ch, int i, int j, int count, String str) {
        if (count == str.length()) {
            return true;
        }
        if (i < 0 || i >= ch.length || j < 0 || j >= ch[i].length || ch[i][j] != str.charAt(count)) {
            return false;
        }
        char temp = ch[i][j];
        ch[i][j] = ' ';
        boolean found = dfs(ch, i + 1, j, count + 1, str) || dfs(ch, i - 1, j, count + 1, str) || dfs(ch, i, j + 1, count + 1, str) || dfs(ch, i, j - 1, count + 1, str);
        ch[i][j] = temp;
        return found;

    }
}
