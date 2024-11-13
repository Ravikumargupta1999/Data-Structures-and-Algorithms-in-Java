package Pattern_Level_1;

import java.util.ArrayList;
import java.util.List;

public class Pattern_13 {
    public static void main(String[] args) {
        int rowIndex = 10;
        System.out.print(1 + "\t");
        System.out.println();
        if (rowIndex == 1)
            return;

        System.out.print(1 + "\t" + 1 + "\t");
        System.out.println();
        if (rowIndex == 2)
            return;

        System.out.print(1 + "\t" + 2 + "\t" + 1 + "\t");
        System.out.println();
        if (rowIndex == 3)
            return;

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(1);
        for (int i = 4;i <= rowIndex; i++) {
            ArrayList<Integer> ans1 = new ArrayList<>();
            ans1.add(1);
            for (int j = 1; j < ans.size(); j++) {
                ans1.add(ans.get(j - 1) + ans.get(j));
            }
            ans1.add(1);
            ans = new ArrayList<>(ans1);
            printList(ans);
        }

    }

    static void printList(ArrayList<Integer> list) {
        for (int val : list) {
            System.out.print(val + "\t");
        }
        System.out.println();
    }
}
