package Sumit_Malik_Level_2;

public class V_Video_28_Check_if_Binary_String_is_Divisible_by_3 {
    // https://practice.geeksforgeeks.org/problems/is-binary-number-multiple-of-30654/1
    // https://www.youtube.com/watch?v=Sd2ZjG20iUA&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=28
    int isDivisible(String s) {
        int even =0;
        int odd = 0;
        for (int i=0;i<s.length();i++){
            int bit = s.charAt(i)-'0';
            if(i % 2 == 0)
                even += bit;
            else
                odd += bit;
        }
//        Sir, I think we should check whether delta%3==0 rather than delta%11==0.
//        As for input string "10101" the decimal is 21 which is divisible by 3, but according to your method it will return false.
//                Correct me if I'm wrong
//
//        7
//
//
//        Pepcoding Pepcoding
//        1 year ago
//        you are correct.
//
//        3


        int delta = even - odd;
        if( delta % 3 == 0)
            return 1;
        else
            return 0;
    }

}
