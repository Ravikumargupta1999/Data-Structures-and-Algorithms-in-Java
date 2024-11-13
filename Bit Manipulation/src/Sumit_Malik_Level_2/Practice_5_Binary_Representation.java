package Sumit_Malik_Level_2;

public class Practice_5_Binary_Representation {
    // https://practice.geeksforgeeks.org/problems/binary-representation5003/1/?page=4&difficulty[]=-2&category[]=Bit%20Magic&sortBy=submissions
    static String getBinaryRep(int n){
        String str = "";
        while (n >= 1) {
            if (n % 2 == 0) {
                str = 0 + str;
            } else {
                str = 1 + str;
            }
            n = n / 2;
        }
        for (int i = str.length(); i < 30; i++) {
            str = 0 + str;
        }

        return str;
    }
}
