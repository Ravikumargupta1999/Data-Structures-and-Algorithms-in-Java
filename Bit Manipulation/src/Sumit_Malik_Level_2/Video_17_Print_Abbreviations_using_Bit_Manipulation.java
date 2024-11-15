package Sumit_Malik_Level_2;

import java.util.Scanner;

public class Video_17_Print_Abbreviations_using_Bit_Manipulation {
    public static void solve(String str) {
        for (int i = 0; i < (1 << str.length()); i++) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                int b = str.length() - 1 - j;
                if ((i & (1 << b)) == 0) {
                    if (count == 0)
                        sb.append(ch);
                    else {
                        sb.append(count);
                        sb.append(ch);
                        count = 0;
                    }
                } else {
                    count++;
                }
            }
            if (count > 0)
                sb.append(count);
            System.out.print(sb + "   ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str);
    }
}
