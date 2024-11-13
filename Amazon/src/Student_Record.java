import java.util.*;
//https://practice.geeksforgeeks.org/problems/student-record1752/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=4&query=company[]Amazondifficulty[]-1page4company[]Amazon

public class Student_Record {
    static String studentRecord(String[][] vec, int n) {
        String[][] res = new String[n][];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res[i] = vec[i][0].split(" ", 4);
            int temp = 0;
            for (int j = 1; j < res[i].length; j++) {
                temp += Integer.parseInt(res[i][j]);
            }
            if (temp/3 > max)
                max = temp/3;
//            System.out.println(Arrays.toString(res[i]));

        }
        String result = "";
        for (int i = 0; i < n; i++) {

            int temp = 0;
            for (int j = 1; j < res[i].length; j++) {
                temp += Integer.parseInt(res[i][j]);
            }
//            System.out.println(temp/3 +"   "+res[i][0] );
            if (temp/3 == max) {
                result += res[i][0] +" ";
            }
//            System.out.println(temp/3 +"   "+res[i][0] +" ");

        }
//        System.out.println(result+"        "+max);
        result += max;
//        System.out.println(result);
       return result;
    }

    public static void main(String[] args) {

        String[][] str = {{"Shrikanth 20 30 10"},{ "Ram 100 50 10"}};
        //  System.out.println(str.length);
        // System.out.println(str[0].length);));
        System.out.println(studentRecord(str,str.length));
    }
}
