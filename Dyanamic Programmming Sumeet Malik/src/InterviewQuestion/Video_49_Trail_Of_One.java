package InterviewQuestion;

public class Video_49_Trail_Of_One {
    // https://practice.geeksforgeeks.org/problems/trail-of-ones3242/1
    static int numberOfConsecutiveOnes(int N) {
        int count = 0;
        for (int i = 1; i <= (int) (Math.pow(2, N - 1)); i++) {
            String sb = Integer.toBinaryString(i);
            System.out.println(sb);
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) == '1' && sb.charAt(j + 1) == '1') {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfConsecutiveOnes(2));
    }
}
