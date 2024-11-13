//https://practice.geeksforgeeks.org/problems/count-numbers-containing-43022/1/?category[]=Dynamic%20Programming&category[]=Dynamic%20Programming&difficulty[]=-2&difficulty[]=-1&page=1&query=category[]Dynamic%20Programmingdifficulty[]-2difficulty[]-1page1category[]Dynamic%20Programming#
public class Video_15_Count_numbers_containing_4 {
    static int countNumbersWith4(int n) {
        int count = 0;
        for (int x = 1; x <= n; x++) {
            int i = x;
            while (i != 0) {

                if (i % 10 == 4) {

                    count++;
                    break;
                }

                i = i / 10;
            }
        }
        return count;

    }

    public static void main(String[] args) {

        System.out.println(countNumbersWith4(50));
    }
}
