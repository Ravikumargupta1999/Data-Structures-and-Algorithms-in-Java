public class Replace_all_0s_with_5 {
// https://practice.geeksforgeeks.org/problems/replace-all-0s-with-5/1

    static int replace0with5(int number)
    {
        return number += calculateAddedValue(number);
    }
    public static int calculateAddedValue(int number) {
        int result = 0;
        int decimalPlace = 1;

        if (number == 0) {
            result += (5 * decimalPlace);
        }

        while (number > 0) {
            if (number % 10 == 0)
                result += (5 * decimalPlace);
            number /= 10;
            decimalPlace *= 10;
            System.out.println(number+"   "+decimalPlace+"   "+result);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(replace0with5(1020));
    }
}
//https://practice.geeksforgeeks.org/problems/replace-all-0-with-5-in-an-input-integer/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-2&page=1&query=company[]Amazondifficulty[]-2page1company[]Amazon
