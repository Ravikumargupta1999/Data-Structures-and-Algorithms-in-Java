public class Practice_9_Replace_All_0s_With_5 {
    // https://practice.geeksforgeeks.org/problems/replace-all-0-with-5-in-an-input-integer/1?page=14&company[]=Amazon&sortBy=submissions

    // 100 -> 155
    //         5
    //         10*5 == 50+ 5 = 55
    //         100*1 = 100 + 55 = 155
    public static int convertFive(int n) {

        int multiply = 1;
        int num = 0;

        while (n != 0) {
            int lastDigit = n % 10;

            num = num + multiply * (lastDigit == 0 ? 5 : lastDigit);
            multiply *= 10;
            n = n / 10;
//            System.out.println(n+"    "+num+"   "+multiply+"   "+lastDigit);
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(convertFive(100));
    }

}
