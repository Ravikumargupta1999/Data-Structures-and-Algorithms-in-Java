package Sumit_Malik_Level_2;

public class Video_11_Element_That_Appears_Once_Where_All_Others_Appear_Thrice {
    // https://practice.geeksforgeeks.org/problems/find-element-occuring-once-when-all-other-are-present-thrice/1/
    // https://www.youtube.com/watch?v=3gJxLkPPW6M&list=PL-Jc9J83PIiFJRioti3ZV7QabwoJK6eKe&index=11
    // will work only for +ve numbers
    public int singleNumber(int[] arr) {
        int[] str = new int[32];
        for (int num : arr) {
            countNum(str, num);
        }
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i] % 3;
        }
//        System.out.println(Arrays.toString(str));
        String temp = "";
        boolean found = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 0 && found == true) {
                temp += str[i];
            }
            else if(str[i] == 1)
            {
//                System.out.println("hhee");
                found = true;
                temp += ""+ str[i];
            }
//            System.out.println(temp+"   "+str[i]);
        }
//        System.out.println(temp);
        if( temp == "")
            return 0;
        return Integer.parseInt(temp,2);
    }
    public  void countNum(int[] str, int num) {
        String temp = Integer.toBinaryString(num);
        int j = str.length - 1;
        int i = temp.length() - 1;
        while (i >= 0) {
            str[j--] += temp.charAt(i) == '1' ? 1 : 0;
            i--;
        }
    }
}
