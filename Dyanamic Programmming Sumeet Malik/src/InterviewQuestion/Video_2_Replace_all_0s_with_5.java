package InterviewQuestion;

public class Video_2_Replace_all_0s_with_5 {

    // https://practice.geeksforgeeks.org/problems/replace-all-0-with-5-in-an-input-integer/1

    public static int convertFive(int num) {
        int pow = 1;
        int newNum = 0;
        while (num != 0) {
            int lastDigit = num % 10 == 0 ? 5 : num % 10;

            num = num / 10;

            newNum = lastDigit * pow + newNum;
            pow = pow * 10;

        }
        return newNum;
    }

    public static void main(String[] args) {
        System.out.println(convertFive(1004));
    }


}
