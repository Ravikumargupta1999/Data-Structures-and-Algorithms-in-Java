public class Container_With_Most_Water {
    public int maxArea(int[] arr) {
        int value = 0;
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            int temp = 0;
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
}
