package Recursion;

import java.util.ArrayList;
import java.util.List;
// https://practice.geeksforgeeks.org/problems/help-the-old-man3848/1#
public class Recursion_8_Tower_Of_Hanoi_Help_The_Old_Man {
    // https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1/
    long stepss = 0;
    public long toh(int n, int a, int b, int c) {
        if(n == 1) {
            System.out.println("move disk "+ (n)+" from rod "+(a)+" to rod "+(b));
            stepss++;
            return stepss;
        }
        toh(n-1,a,c,b);
        System.out.println("move disk "+ (n)+" from rod "+(a)+" to rod "+(b));
        stepss++;
        toh(n-1,c,b,a);
        return stepss;
    }

    //  https://practice.geeksforgeeks.org/problems/help-the-old-man3848/1#
    static   List<Integer> al = new ArrayList<>();
    static List<Integer> shiftPile(int N, int n) {
        toh(N, 1, 2, 3,n);
        return al;
    }

    static long step = 1;
    // https://www.youtube.com/watch?v=q6RicK1FCUs
    // to 3 from 1 using 2
    public static void toh(int n, int a, int b, int c, int count) {
        if (n == 1) {
//            System.out.println("move disk " + (n) + " from rod " + (a) + " to rod " + (c));
            if( step == count)
            {
                al.add(a);
                al.add(c);
            }
            step++;
            return;
        }
        toh(n - 1, a, c, b,count);
//        System.out.println("move disk " + (n) + " from rod " + (a) + " to rod " + (c));
        if( step == count)
        {
            al.add(a);
            al.add(c);
        }
        step++;
        toh(n - 1, b, a,c,count);

    }

    public static void main(String[] args) {
        System.out.println(shiftPile(4,5));
    }
}
//    vector<int>al;
//    int step ;
//    vector<int> shiftPile(int N, int n){
//        step = 1;
//        toh(N, 1, 2, 3,n);
//        return al;
//    }
//
//    void toh(int n, int a, int b, int c, int count) {
//        if (n == 1) {
//            if( step == count)
//            {
//                al.push_back(a);
//                al.push_back(c);
//            }
//            step++;
//            return;
//        }
//        toh(n - 1, a, c, b,count);
//        if( step == count)
//        {
//            al.push_back(a);
//            al.push_back(c);
//        }
//        step++;
//        toh(n - 1, b, a,c,count);
//
//    }