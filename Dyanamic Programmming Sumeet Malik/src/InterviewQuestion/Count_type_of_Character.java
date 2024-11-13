package InterviewQuestion;

public class Count_type_of_Character {
    public Count_type_of_Character() {
    }

    int[] fun(String str) {
        int[] arr = new int[4];

        for(int i = 0; i < str.length(); ++i) {
            int var10002;
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                var10002 = arr[0]++;
            } else if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                var10002 = arr[1]++;
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                var10002 = arr[2]++;
            } else {
                var10002 = arr[3]++;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
    }
}
