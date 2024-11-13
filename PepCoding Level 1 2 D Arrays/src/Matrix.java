import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Matrix {
    public static String MatrixSpiral(String[] arr) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (String str : arr) {
            ArrayList<Integer> temp = new ArrayList<>();
            String num = "";
            for (char ch : str.toCharArray()) {
                if (ch == '[')
                    continue;
                else if (ch == ' ')
                    continue;
                else if (Character.isDigit(ch)) {
                    num += ch;
                } else if (ch == ',' || ch == ']') {
                    temp.add(Integer.parseInt(num));
                    num = "";
                }
            }
            al.add(temp);
        }
        int[][] tempArray = new int[al.size()][al.get(0).size()];
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(0).size(); j++) {
                tempArray[i][j] = al.get(i).get(j);
            }
        }
        String ans = "";
        ArrayList<Integer> a = spirallyTraverse(tempArray, tempArray.length, tempArray[0].length);

        for (int val : a) {
            ans += val + "";
        }
        ans = ans.substring(0,ans.length()-1);
        return ans;
    }

    static ArrayList<Integer> spirallyTraverse(int[][] arr, int n, int m) {
        ArrayList<Integer> value = new ArrayList<>();
        int minr = 0;
        int minc = 0;
        int maxr = arr.length - 1;
        int maxc = arr[0].length - 1;
        int total = n * m;
        int count = 0;
        while (count < total) {
            for (int i = minr, j = minc; j <= maxc && count < total; j++) {
                //  System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            minr++;
            for (int i = minr, j = maxc; i <= maxr && count < total; i++) {
                //System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            maxc--;
            for (int i = maxr, j = maxc; j >= minc && count < total; j--) {
                // System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            maxr--;
            for (int i = maxr, j = minc; i >= minr && count < total; i--) {
                // System.out.println(arr[i][j]+"  ");
                value.add(arr[i][j]);
                count++;
            }
            minc++;
        }
        return value;
    }
}
