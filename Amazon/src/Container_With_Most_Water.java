//https://practice.geeksforgeeks.org/problems/container-with-most-water0535/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Arrayscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Arrays
public class Container_With_Most_Water {
    static long maxArea1(int arr[], int n) {
        long value = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long temp = 0;
            for (int j = i + 1; j < n; j++) {
                temp = (j - i) * Math.min(arr[i], arr[j]);
                if (temp > value)
                    value = temp;
            }
        }
        if (value == Integer.MIN_VALUE)
            return 0;
        return value;
    }

    static long maxArea2(int arr[], int n) {
        long value = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            long temp = 0;
            temp = (j - i) * Math.min(arr[i], arr[j]);
            if (temp > value)
                value = temp;
            if (arr[i] < arr[j])
                i++;
            else
                j--;

        }
        return value;
    }

    public static void main(String[] args) {
        int n = 4;
        int arr[] = {1, 5, 4, 4};
        System.out.println(maxArea1(arr, n));
    }
}
