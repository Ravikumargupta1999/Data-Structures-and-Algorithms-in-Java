public class Number_of_Groups {
    static Long noOfGroups(int N, int[] arr) {
        long count = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum % 3 == 0) {
                    count++;
                }
                int k = j + 1;
                while (i < arr.length - 2 && j < arr.length - 1 && k < arr.length) {
                    sum2 = arr[i] + arr[j] + arr[k];
                    if (sum2 % 3 == 0) {
                        count++;
                    }
                    k++;
                }

            }
        }
        return count;
    }
}
