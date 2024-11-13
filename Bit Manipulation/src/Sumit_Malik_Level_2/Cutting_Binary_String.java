package Sumit_Malik_Level_2;

import java.util.Scanner;

public class Cutting_Binary_String {
    static int cuts(String s) {
        return 1;
    }
    static int pieces(String s,String ans,int C){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        int t = Integer.parseInt(s1);
        while (t-- >0){
            String s2 = scn.nextLine();
            int n = Integer.parseInt(s1);
            int[] arr = new int[n];
            for (int i=0;i<n;i++){
                arr[i] = scn.nextInt();
            }
            int res = Integer.MAX_VALUE;
            int rightSum = 0;
            for (int val : arr)
                rightSum += val;
            int leftSum = 0;
            for (int val : arr){
                leftSum += val;
                rightSum -= val;
                res = Math.min(res,Math.max(leftSum,rightSum));
            }
            System.out.println(res);
        }
        return 6;
//        if(s.length() == 0)
//            return C;
//        char ch = s.charAt(0);
//        if(ch == '0'){
//            ans += ch;
//            if(Integer.parseInt(s,2) % 5 == 0){
//                return Math.min(pieces(s.substring(0),"",C+1),Math.m)
//            }
//            return Math.min(pieces(s.substring(1,ans),))
//        }
    }
}
