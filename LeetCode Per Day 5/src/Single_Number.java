public class Single_Number {
    int getSingle(int arr[], int n) {
        // code here
        int num = 0;
        for (int ele : arr)
            num = num ^ ele;
        return num;
    }
}
