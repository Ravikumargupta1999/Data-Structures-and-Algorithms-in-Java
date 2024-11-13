import java.util.ArrayList;

public class String_79_Find_the_string_in_grid {
    // https://practice.geeksforgeeks.org/problems/find-the-string-in-grid0111/1#
    public int[][] searchWord(char[][] ch, String str) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < ch[0].length; j++) {
                if (check(ch, i, j, str)) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(i);
                    arrayList.add(j);
                    result.add(arrayList);
                }
            }
        }
        if (result.size() == 0)
            return new int[0][0];
        int[][] ans = new int[result.size()][2];
        int i = 0;
        for (ArrayList<Integer> arrayList : result) {
            ans[i][0] = arrayList.get(0);
            ans[i][1] = arrayList.get(1);
            i++;
        }
        return ans;
    }

    public static boolean check(char[][] arr, int i, int j, String str) {

        if (arr[i][j] != str.charAt(0)) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        // Call DFS In 8 direction
//        System.out.println(i + "    " + j + "    call starts");
        boolean val = dfs(arr, i - 1, j - 1, 1, str, 0) ||
                dfs(arr, i - 1, j, 1, str, 1) ||
                dfs(arr, i - 1, j + 1, 1, str, 2) ||
                dfs(arr, i, j + 1, 1, str, 3) ||
                dfs(arr, i + 1, j + 1, 1, str, 4) ||
                dfs(arr, i + 1, j, 1, str, 5) ||
                dfs(arr, i + 1, j - 1, 1, str, 6) ||
                dfs(arr, i, j - 1, 1, str, 7);
//        System.out.println(i + "  " + j + "   " + val + "    ends ");
        return val;

    }

    public static boolean dfs(char[][] ch, int i, int j, int index, String str, int dir) {
        if (index == str.length()) {
            return true;
        }
//        System.out.println("row :  " + i + " , col : " + j + ",  dir : " + dir + " ,   index :  " + index + "  " + str);
        if (i < 0 || i >= ch.length || j < 0 || j >= ch[0].length || ch[i][j] != str.charAt(index)) {
            return false;
        }
//        System.out.println(i + "   " + j + "    ke liye ander aaya  " + index + "      " + (str.length() - 1) + "   " + dir);
//       // ye call bhi valid hai
//        if (index == str.length() - 1) {
//            return true;
//        }
//        System.out.println(i + "   " + j + "    ke liye ander aaya  " + index + "      " + (str.length() - 1) + "   " + dir);
        char temp = ch[i][j];
        ch[i][j] = ' ';
        boolean found = false;
        if (dir == 0) {
            found = dfs(ch, i - 1, j - 1, index + 1, str, 0);
        } else if (dir == 1) {
            found = dfs(ch, i - 1, j, index + 1, str, 1);
        } else if (dir == 2) {
            found = dfs(ch, i - 1, j + 1, index + 1, str, 2);
        } else if (dir == 3) {
            found = dfs(ch, i, j + 1, index + 1, str, 3);
        } else if (dir == 4) {
            found = dfs(ch, i + 1, j + 1, index + 1, str, 4);
        } else if (dir == 5) {
            found = dfs(ch, i + 1, j, index + 1, str, 5);
        } else if (dir == 6) {
            found = dfs(ch, i + 1, j - 1, index + 1, str, 6);
        } else if (dir == 7) {
            found = dfs(ch, i, j - 1, index + 1, str, 7);
        }
        ch[i][j] = temp;
        return found;
    }


}
//
//        bbddedbdd
//        bcbcecadc
//        aebedbeed
//        dcdecbbbe
//        bcaeccdaa
//        aacbacaca
//        acbdbdbec
//        dcb