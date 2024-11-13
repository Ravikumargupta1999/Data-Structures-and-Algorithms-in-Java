package Biweekly_Contest_89;

import java.util.ArrayList;

public class Program_1 {
    public static void main(String[] args) {
       System.out.println(countTime("1?:00"));
    }

    public static int countTime(String time) {
        int hour = 1;
        int minute = 1;
        for(int i = 0;i<=time.length();i++){
            if(i == 0 && time.charAt(i) == '?'){

                if(time.charAt(i+1) == '?' && time.charAt(i) == '?')
                    hour = 24;
                else if(Integer.parseInt(String.valueOf(time.charAt(i+1))) < 4)
                    hour = 3;
                else
                    hour = 2;

            }
            if(i == 1 && time.charAt(i) == '?' && time.charAt(i-1) != '?'){
                if(time.charAt(i-1) =='1' || time.charAt(i-1) == '0')
                    hour = 10;
                else
                    hour = 4;
            }
            if(i == 3 && time.charAt(i) == '?'){
                if(time.charAt(i+1) == '?')
                    minute = 60;
                else
                    minute = 6;
            }
            if(i == 4 && time.charAt(i) == '?' && time.charAt(i-1) != '?')
                minute = 10;




        }

        return minute * hour;
    }


}
