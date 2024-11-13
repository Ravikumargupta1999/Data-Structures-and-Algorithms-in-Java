package InterviewQuestion;

public class Video_19_Look_And_Say {
    static String lookandsay(int n) {
        if (n == 1)
            return "1";
        else if (n == 2)
            return "11";
        StringBuilder res = new StringBuilder("11");

        for (int i = 3; i <= n; i++) {
            int count = 1;
            char prev = res.charAt(0);
            StringBuilder temp = new StringBuilder("");

            for (int j = 1; j < res.length(); j++) {

                char curr = res.charAt(j);
                if (curr == prev)
                    count++;
                else {
                    temp.append(count);
                    temp.append(prev);
                    count = 1;
                    prev = curr;
                }
            }

            temp.append(count);
            temp.append(prev);
            res = temp;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookandsay(5));
    }
}
