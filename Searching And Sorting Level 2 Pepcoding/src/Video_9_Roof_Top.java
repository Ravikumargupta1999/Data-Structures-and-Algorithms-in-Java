public class Video_9_Roof_Top {
    static int maxStep(int arr[], int n) {
        int ans = 0;
        int prev = arr[0];
        for (int i = 1; i < n; i++) {
            int temp = 0;
            while (i < n && arr[i] > prev) {
                temp++;
                prev = arr[i];
                i++;

            }
            if (i != arr.length)
                prev = arr[i];
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    static int maxStep1(int arr[], int n) {
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                temp++;
            } else {
                ans = Math.max(temp, ans);
                temp = 0;
            }
        }
        ans = Math.max(temp, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 2, 4, 6, 9, 11};
        System.out.println(maxStep(arr, arr.length));
    }
}
//
// class Attendance {
//    static void att(int[] arr) {
//        Arrays.sort(arr);
//        System.out.println("Total present : " + arr.length);
//        for (int i = 0; i < arr.length; i++)
//            System.out.print(arr[i] + "  ");
//        System.out.println(" ");
//        System.out.println("");
//        System.out.println("");
//        System.out.println("Total Absent : " + (72 - arr.length));
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        for (int i = 1; i <= 72; i++) {
//            if (set.contains(i) == false)
//                System.out.print(i + "  ");
//        }
//        System.out.println(" ");
//    }
//
//    public static void main(String[] args) {
////        String str = "Digital Marketing Management module under Student Leadership Programme  TE COMP A ATTENDANCE";
////        System.out.println(str.toUpperCase() + "   " + java.time.LocalDate.now());
//        int[] arr = {65, 69, 10, 24, 61, 19, 23, 32, 51, 34, 43, 5, 14, 42, 60, 41, 56, 17, 18, 9, 8, 71, 1, 25, 2, 37, 39, 49, 4, 67, 58, 45, 48,
//                3, 29, 13, 68, 16, 38, 12, 54, 64, 57, 15, 50, 30, 20, 27,59,44,55,7,26, 36, 72, 40, 46, 47, 21, 11,70, 28, 31, 6, 62, 52, 66, 63, 22, 35, 53};
//
//        for(int i : arr)
//            System.out.print(i+"  ");
//        att(arr);
//    }
//}