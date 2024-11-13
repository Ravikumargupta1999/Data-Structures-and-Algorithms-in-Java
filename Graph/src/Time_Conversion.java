public class Time_Conversion {
    // https://www.hackerrank.com/contests/hackerrank-internship-challenges/challenges/time-conversion/submissions/code/1347457693
    public static String timeConversion(String s) {
        String[] arr = s.split(":");

        if (arr[2].substring(2).equals("AM")) {
            arr[2] = arr[2].substring(0, 2);
            if (Integer.parseInt(arr[0]) >= 12) {
                int val = Integer.parseInt(arr[0]);
                val = val - 12;
                arr[0] = val > 9 ? Integer.toString(val) : "0" + val;
            }
        } else {
            arr[2] = arr[2].substring(0, 2);
            if (Integer.parseInt(arr[0]) < 12) {
                int val = Integer.parseInt(arr[0]);
                val = 12 + val;
                arr[0] = val + "";
            }
        }
        return arr[0] + ":" + arr[1] + ":" + arr[2];

    }

    public static void main(String[] args) {
        System.out.println(timeConversion("17:01:00AM"));
    }
}
