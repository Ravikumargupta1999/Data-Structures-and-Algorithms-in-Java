package InterviewQuestion;

import java.util.ArrayList;

public class Video_4_Generate_Binary_Numbers {
    public Video_4_Generate_Binary_Numbers() {
    }

    static ArrayList<String> generate(int n) {
        ArrayList<String> result = new ArrayList();
        if (n == 0) {
            return new ArrayList();
        } else {
            for(int i = 1; i <= n; ++i) {
                int temp = i;

                String str;
                for(str = ""; temp > 0; temp /= 2) {
                    if (temp % 2 == 0) {
                        str = '0' + str;
                    } else {
                        str = '1' + str;
                    }
                }

                result.add(str);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        System.out.println(generate(11));
    }
}
