public class Video_38_Punish_the_Students {
    //https://practice.geeksforgeeks.org/problems/punish-the-students5726/1
    public static int shouldPunish(int roll[], int marks[], int n, double avg) {
        int count = bubbleSort(roll);
        int sum = 0;
        for (int val : marks)
            sum += val;
        double m = n;

        double ans = (sum - count) / m;
//        System.out.println(ans+ "   "+avg+"   "+count+"   "+sum+"   "+m);
        if (ans >= avg)
            return 1;
        else return 0;
    }

    static int bubbleSort(int arr[]) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count += 2;
                }
        }
        return count;
    }

    public static void main(String[] args) {
        int N = 6;
        double avg = 67.5;
        int roll[] = {5, 4, 1, 3, 2, 6};
        int marks[] = {78, 98, 86, 67, 78, 79};
        System.out.println(shouldPunish(roll, marks, N, avg));
    }

}
